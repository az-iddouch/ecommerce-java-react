package com.vash.service;

import java.util.List;

import com.vash.domaine.CityVo;

public interface ICityService {

	CityVo save(CityVo cityVo);
	List<CityVo> findAll();
	List<CityVo> findByNameCityIgnoreCaseContaining(String namecity);
}
