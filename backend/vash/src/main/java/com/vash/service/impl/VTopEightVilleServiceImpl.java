package com.vash.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vash.dao.IVTopEightVilleRepository;
import com.vash.domaine.VTopEightVilleConverter;
import com.vash.domaine.VTopEightVilleVo;
import com.vash.security.aop.LogTracer;
import com.vash.service.IVTopEightVilleService;

@Service
@Transactional
public class VTopEightVilleServiceImpl implements IVTopEightVilleService {
@Autowired
private IVTopEightVilleRepository iVTopEightVilleRepository;
	
	@Override
	@LogTracer
	public List<VTopEightVilleVo> findAll() {
		return VTopEightVilleConverter.toListVo(iVTopEightVilleRepository.findAll());
	}

}
