package com.manitou.userauth.service;

import org.springframework.stereotype.Service;

import com.manitou.userauth.entity.Response;
import com.manitou.userauth.entity.Role;
 

@Service
public interface RoleService {

	public Response findAllRole() throws Exception;
	public Response getRoleById(String roleId) throws Exception;
	public Role findByRoleName(String roleName) throws Exception;
}
