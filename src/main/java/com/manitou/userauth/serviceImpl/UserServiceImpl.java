package com.manitou.userauth.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.manitou.userauth.constant.AuthConstant;
import com.manitou.userauth.constant.ManitouConstants;
import com.manitou.userauth.entity.Branch;
import com.manitou.userauth.entity.Response;
import com.manitou.userauth.entity.Role;
import com.manitou.userauth.entity.User;
import com.manitou.userauth.entity.UserForResetPassword;
import com.manitou.userauth.repository.UserRepository;
import com.manitou.userauth.security.PasswordEncoderUtility;
import com.manitou.userauth.service.BranchService;
import com.manitou.userauth.service.RoleService;
import com.manitou.userauth.service.UserService;

/*
*Added by Vivek Kumar. serviceImple class create the communication between DB and user entity for DB operation
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BranchService branchService;

	@Override
	public Response findAllUser() throws Exception {
		try {
			logger.info("findAllUser()::::::::: method in UserServiceImpl");

			List<User> alluser = userRepo.findAll();
			if (alluser.size() == 0) {
				logger.error("Error::::: No record found");
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			}
			logger.info("Users fetched successfully !!!!!!!!");
			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, alluser);

		} catch (Exception e) {
			e.printStackTrace();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public User findByUserId(String userId) {
		try {
			User user = userRepo.findByUserId(userId);
			if (user != null)
				return user;
			else {
				logger.error(userId + " user id does  not exist");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:::::::::" + e.getMessage());
			return null;
		}
	}

	@Override
	public Response findById(Long id) throws Exception {
		try {
			logger.info("findByUserId():::method in UserServiceImpl");

			Optional<User> user = userRepo.findById(id);

			if (user.isPresent()) {
				logger.info("User details are fetched successfully for userid :::::: " + id);
				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, user);
			} else {
				logger.error("No record found for the userid :::::::::: " + id);
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:::::::::: in findByUserId()");
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

	public User findByUserName(String l_username) {

		return userRepo.findByUserName(l_username);
	}

	/*
	 * this method is use to save the new user
	 * 
	 */
	@Override
	public Response saveUser(User user) {
		try {
			logger.info("saveUser()::::::: method in UserServiceImpl");

			Optional<User> ofNullable = Optional.ofNullable(userRepo.findByUserId(user.getUserId()));

			if (!ofNullable.isPresent()) {

				user.setPassword(PasswordEncoderUtility.passwordEncoder(user.getPassword()));
				user.setLocked_status("N");
				user.setIncorrect_attempt(0);
				user.setIncorrect_max_attempt_limit(ManitouConstants.INCORRECT_MAX_ATTEMPT_LIMIT);
				user.setFisrt_login_status("N");
				user.setStatus("N");

				if (user.getRoles() != null) {
					Set<Role> newuserRoles = user.getRoles();
					Set<Role> rolesforUser = new HashSet<>();

					for (Role role : newuserRoles) {
						String roleId = role.getRoleId();
						Role rolesinTable = (Role) roleService.getRoleById(roleId).getData();

						if (rolesinTable != null)
							rolesforUser.add(rolesinTable);
						else
							return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE,
									AuthConstant.NO_RECORD_FOUND + " FOR THE PROVIDED ROLE");
					}

					user.setRoles(rolesforUser);
				}

				if (user.getBranch() != null) {
					String branchId = user.getBranch().getBranchId();
					Response branchResponse = branchService.getBranchById(branchId);

					if (branchResponse.getData() != null) {
						user.setBranch((Branch) branchResponse.getData());
					} else {
						return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE,
								AuthConstant.NO_RECORD_FOUND + " FOR THE PROVIDED BRANCH");
					}
				}
				User saveUser = userRepo.save(user);
				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, saveUser);
			} else {
				logger.error("Error:::::::::::::Data already exist for userid " + user.getUserId());
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.DATA_EXIST);
			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

	/*
	 * this method is to update the data of the existing user
	 * 
	 */
	@Override
	public Response updateUser(User user) throws Exception {

		try {
			logger.info("updateUser()::::::: method in UserServiceImpl");

			Optional<User> userData = Optional.ofNullable(findByUserId(user.getUserId()));

			Optional<Authentication> _checkauthentication = Optional
					.ofNullable(SecurityContextHolder.getContext().getAuthentication());

			String loginusername = "";
			if (_checkauthentication.isPresent()) {
				Object principal = _checkauthentication.get().getPrincipal();
				if (principal instanceof UserDetails) {
					loginusername = ((UserDetails) principal).getUsername();

				}
			}

			User loginuser = findByUserName(loginusername);

			Set<Role> roles = loginuser.getRoles();

			String[] roleOfLoginUser = new String[roles.size()];

			int i = 0;
			for (Role role : roles) {
				roleOfLoginUser[i++] = role.getRoleId();

			}

			boolean rolepresent = false;
			for (String role : roleOfLoginUser) {
				if (role.equals(ManitouConstants.ROLE_SUPERADMIN)) {
					rolepresent = true;
				}
			}
			if (rolepresent == true || userData.get().getUserId().equals(loginuser.getUserId())) {
				if (userData.isPresent()) {

					userData.get().setUserName(user.getUserName());
					userData.get().setPassword(PasswordEncoderUtility.passwordEncoder(user.getPassword()));
					userData.get().setMobile(user.getMobile());
					userData.get().setEmail(user.getEmail());

					if (user.getRoles() != null) {
						Set<Role> newRoleForUser = user.getRoles();
						Set<Role> rolesforUser = new HashSet<>();

						for (Role role : newRoleForUser) {
							String roleId = role.getRoleId();
							Role rolesinTable = (Role) roleService.getRoleById(roleId).getData();

							if (rolesinTable != null) {
								rolesforUser.add(rolesinTable);
							} else {
								throw new Exception("Provided Role not present");
							}

						}

						userData.get().setRoles(rolesforUser);
					}

					User saveUser = userRepo.save(userData.get());
					logger.info(
							loginusername + " user updated the data successfully for ....... " + user.getUserName());
					return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, saveUser);
				} else {
					logger.error("Error::::::::::Userid not present");
					return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.USERID_NOT_PRESENT);
				}
			} else {
				logger.error("Error::::::::::User is not authorized to upadate the data " + loginusername);
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.USER_UNAUTHORIZED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

	/*
	 * this method is to delete the user on the basis of its ID
	 * 
	 */
	@Override
	public Response deleteUserById(String userId) throws Exception {
		logger.info("deleteUserById():::::: method in UserServiceImpl " + userId);
		try {
			int deletedUser = userRepo.deleteByUserId(userId);

			if (deletedUser == 0) {
				logger.error("No record found to delete for userid ::: " + userId);
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			} else {
				logger.info("Record deleted for userid ::: " + userId);
				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, AuthConstant.RECORD_DELETED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());

		}
	}

	@Override
	public Response updateUserWhileAuthentication(User user) throws Exception {
		logger.info("update user at authentication user service impl called ::::::::::::::: Activity started  " + user);
		try {
			// User users = getLoggedUserDetails(user.getUserId());
			// users.set (PasswordEncoderUtility.passwordEncoder(user.getPassword()));
			User userss = userRepo.save(user);
			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, userss);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());

		}
	}

	@Override
	public Response resetUserPassword(UserForResetPassword user) throws Exception {
		logger.info("reset user service impl called ::::::::::::::: Activity started  " + user);
		try {
			User users = findByUserId(user.getUserId());
			users.setPassword(PasswordEncoderUtility.passwordEncoder(user.getNewPassword()));
			User userss = userRepo.save(users);
			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, userss);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());

		}
	}

	@Override
	public Response userLocked(String userId, String lockedStatus) {
		logger.info(" user locked service impl called ::::::::::::::: Activity started  " + userId);
		try {
			User users = findByUserId(userId);
			if (lockedStatus.equals("N")) {
				users.setLocked_status("N");
			} else if (lockedStatus.equals("Y")) {
				users.setLocked_status("Y");
			}
			User userss = userRepo.save(users);
			logger.info(" user locked service impl called ::::::::::::::: Activity end  ");
			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, userss);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());

		}
	}

}
