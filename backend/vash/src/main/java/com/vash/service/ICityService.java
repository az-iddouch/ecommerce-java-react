package com.vash.service;

import java.util.List;

import com.vash.domaine.CityVo;
import com.vash.entities.City;

public interface ICityService {

	City save(CityVo cityVo);
	List<CityVo> findAll();
}
