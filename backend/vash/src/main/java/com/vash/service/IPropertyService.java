package com.vash.service;

import java.util.Date;
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
	List<PropertyVo> findByCityNameCityAndVisibleTrueAndNumberMaxPersons(String nameCity,Integer numberMaxPersons);

	List<PropertyVo> findByCityNameCityAndVisibleTrueAndBetweenDate(String nameCity,Date dateStart,Date dateEnd);
	List<PropertyVo> findByCityNameCityAndVisibleTrueAndNumberMaxPersonsBetweenDate(String nameCity,Integer numberMaxPersons,Date dateStart,Date dateEnd);
	boolean deleteById(Long id);
}
