package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.IRoleRepository;
import com.vash.domaine.RoleConverter;
import com.vash.domaine.RoleVo;
import com.vash.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
@Autowired
private IRoleRepository iRoleRepository;
	@Override
	public RoleVo save(RoleVo roleVo) {
		return RoleConverter.toVo(iRoleRepository.save(RoleConverter.toBo(roleVo)));
	}

	@Override
	public List<RoleVo> findAll() {
		return RoleConverter.toListVo(iRoleRepository.findAll());
	}

}
