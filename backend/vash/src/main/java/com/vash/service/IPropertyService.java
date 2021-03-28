package com.vash.service;

import java.util.List;

import com.vash.domaine.CityVo;
import com.vash.domaine.PropertyVo;

public interface IPropertyService {

	PropertyVo save(PropertyVo PropertyVo);
	List<PropertyVo> findAll();
	List<PropertyVo> findByCityNameCity(String nameCity);
	Integer countPropertyInCity(CityVo cityVo);
	PropertyVo findById(Long id);
	List<PropertyVo> findByCityNameCityAndVisibleTrue(String nameCity);
}
