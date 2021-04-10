package com.vash.service;

import java.util.List;

import com.vash.domaine.RoleVo;

public interface IRoleService {

	RoleVo save(RoleVo roleVo);
	List<RoleVo> findAll();
	RoleVo findById(Long id);
	boolean deleteById(Long id);
	public RoleVo findByRole(String client);
}
