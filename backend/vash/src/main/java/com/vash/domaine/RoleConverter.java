package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Role;

public class RoleConverter {

	public static RoleVo toVo(Role role) {
		RoleVo roleVo=null;
		if(!ObjectUtils.isEmpty(role)) {
			roleVo=new RoleVo();
			roleVo.setId(role.getId());
			roleVo.setRole(role.getRole());
			roleVo.setUsers(UserConverter.toListVo(role.getUsers()));
		}
		
		return roleVo;
	}
	
	public static Role toBo(RoleVo roleVo) {
		Role role=null;
		if(!ObjectUtils.isEmpty(roleVo)) {
			role=new Role();
			role.setId(roleVo.getId());
			role.setRole(roleVo.getRole());
			role.setUsers(UserConverter.toListBo(roleVo.getUsers()));
		}
		return role;
	}
	
	public static List<Role> toListBo(List<RoleVo> roleVos) {
		List<Role> roles=new ArrayList<Role>();
		if(!ObjectUtils.isEmpty(roleVos)) {
			for (RoleVo roleVo : roleVos) {
				roles.add(toBo(roleVo));
			}
		}
		return roles;
	}
	
	public static List<RoleVo> toListVo(List<Role> roles) {
		List<RoleVo> roleVos=new ArrayList<RoleVo>();
		if(!ObjectUtils.isEmpty(roles)) {
			for (Role role : roles) {
				roleVos.add(toVo(role));
			}
		}
		return roleVos;
	}
	
}
