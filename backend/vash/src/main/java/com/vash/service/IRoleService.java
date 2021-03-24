package com.vash.service;

import java.util.List;

import com.vash.domaine.RoleVo;

public interface IRoleService {

	RoleVo save(RoleVo roleVo);
	List<RoleVo> findAll();
}
