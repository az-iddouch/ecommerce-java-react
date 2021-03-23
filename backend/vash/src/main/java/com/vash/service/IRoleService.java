package com.vash.service;

import java.util.List;

import com.vash.domaine.RoleVo;
import com.vash.entities.Role;

public interface IRoleService {

	Role save(RoleVo roleVo);
	List<RoleVo> findAll();
}
