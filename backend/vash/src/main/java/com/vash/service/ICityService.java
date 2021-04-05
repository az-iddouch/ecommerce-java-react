package com.vash.service;

import java.util.List;
import java.util.Map;

import com.vash.domaine.CityVo;

public interface ICityService {

	CityVo save(CityVo cityVo);
	List<CityVo> findAll();
	List<CityVo> findByNameCityIgnoreCaseContaining(String namecity);
	Map<CityVo,Integer> countPropertyByCity(String nameCountry);
	CityVo findByNameCityIgnoreCase(String namecity);
	
	List<CityVo> findByCountryNameCountry(String nameCountry);
}
