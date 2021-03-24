package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.ICityRepository;
import com.vash.domaine.CityConverter;
import com.vash.domaine.CityVo;
import com.vash.service.ICityService;

@Service
@Transactional
public class CityServiceImpl implements ICityService{

	@Autowired
	private ICityRepository iCityRepository;

	@Override
	public CityVo save(CityVo cityVo) {
		return CityConverter.toVo(iCityRepository.save(CityConverter.toBo(cityVo)));
	}

	@Override
	public List<CityVo> findAll() {
		return CityConverter.toListVo(iCityRepository.findAll());
	}

	@Override
	public List<CityVo> findByNameCityIgnoreCaseContaining(String namecity) {
		return CityConverter.toListVo(iCityRepository.findByNameCityIgnoreCaseContaining(namecity));
	}
}
