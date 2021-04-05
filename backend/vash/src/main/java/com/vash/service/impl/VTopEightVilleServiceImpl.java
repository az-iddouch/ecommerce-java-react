package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vash.dao.IVTopEightVilleRepository;
import com.vash.domaine.VTopEightVilleConverter;
import com.vash.domaine.VTopEightVilleVo;
import com.vash.service.IVTopEightVilleService;

public class VTopEightVilleServiceImpl implements IVTopEightVilleService {
@Autowired
private IVTopEightVilleRepository iVTopEightVilleRepository;
	
	@Override
	public List<VTopEightVilleVo> findAll() {
		return VTopEightVilleConverter.toListVo(iVTopEightVilleRepository.findAll());
	}

}
