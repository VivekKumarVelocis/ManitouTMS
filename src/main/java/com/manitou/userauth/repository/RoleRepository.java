package com.manitou.userauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manitou.userauth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByRoleDesc(String roleName);

	public Role findByRoleId(String roleId);
}
