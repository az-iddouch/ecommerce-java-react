package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IRoleRepository;
import com.vash.domaine.RoleConverter;
import com.vash.domaine.RoleVo;
import com.vash.entities.Role;
import com.vash.security.aop.LogTracer;
import com.vash.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
@Autowired
private IRoleRepository iRoleRepository;
	@Override
	@LogTracer
	public RoleVo save(RoleVo roleVo) {
		return RoleConverter.toVo(iRoleRepository.save(RoleConverter.toBo(roleVo)));
	}

	@Override
	@LogTracer
	public List<RoleVo> findAll() {
		return RoleConverter.toListVo(iRoleRepository.findAll());
	}

	@Override
	@LogTracer
	public RoleVo findById(Long id) {
		Optional<Role> roleOptional=iRoleRepository.findById(id);
		RoleVo roleVo=new RoleVo();
		if(roleOptional.isPresent()) {
			roleVo=RoleConverter.toVo(roleOptional.get());
		}
		return roleVo;
	}

	@Override
	@LogTracer
	public boolean deleteById(Long id) {
		boolean checked=true;
		iRoleRepository.deleteById(id);
		RoleVo roleVo= findById(id);
		if(!ObjectUtils.isEmpty(roleVo)) {
			checked=true;
		}
		return checked;
	}

	@Override
	@LogTracer
    public RoleVo findByRole(String client) {
		return RoleConverter.toVo(iRoleRepository.findByRole(client));
	}
}
