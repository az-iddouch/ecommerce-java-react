package com.vash.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IPropertyRepository;
import com.vash.domaine.CityVo;
import com.vash.domaine.PropertyConvert;
import com.vash.domaine.PropertyVo;
import com.vash.entities.Property;
import com.vash.service.IPropertyService;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService {
	
	@Autowired
	private IPropertyRepository iPropertyRepository;

	@Override
	public PropertyVo save(PropertyVo PropertyVo) {
		return PropertyConvert.toVo(iPropertyRepository.save(PropertyConvert.toBo(PropertyVo)));
	}

	@Override
	public List<PropertyVo> findAll() {
		return PropertyConvert.toListVo(iPropertyRepository.findAll());
	}

	@Override
	public List<PropertyVo> findByCityNameCity(String nameCity) {
		return PropertyConvert.toListVo(iPropertyRepository.findByCityNameCity(nameCity));
	}

	@Override
	public Integer countPropertyInCity(CityVo cityVo) {
		Integer count =0;
		List<PropertyVo> propertyVos=findByCityNameCity(cityVo.getNameCity());
		if(!ObjectUtils.isEmpty(propertyVos)) {
			count=propertyVos.size();
		}
		return count;
	}

	@Override
	public PropertyVo findById(Long id) {
		PropertyVo propertyVo=null;
		Optional<Property> property =iPropertyRepository.findById(id);
		if(property.isPresent()) {
			propertyVo=PropertyConvert.toVo(property.get());
		}
		return propertyVo;
	}

	@Override
	public List<PropertyVo> findByCityNameCityAndVisibleTrue(String nameCity) {
		return PropertyConvert.toListVo(iPropertyRepository.findByCityNameCityAndVisibleTrue(nameCity));
	}

	@Override
	public List<PropertyVo> findByCityNameCityAndVisibleTrueAndNumberMaxPersons(String nameCity,
			Integer numberMaxPersons) {
		return  PropertyConvert.toListVo(iPropertyRepository.findByCityNameCityAndVisibleTrueAndNumberMaxPersons(nameCity,numberMaxPersons));
	}

	@Override
	public List<PropertyVo> findByCityNameCityAndVisibleTrueAndBetweenDate(String nameCity, Date dateStart,
			Date dateEnd) {
		
		return null;
	}

	@Override
	public List<PropertyVo> findByCityNameCityAndVisibleTrueAndNumberMaxPersonsBetweenDate(String nameCity,
			Integer numberMaxPersons, Date dateStart, Date dateEnd) {
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean checked=true;
		iPropertyRepository.deleteById(id);
		PropertyVo propertyVo= findById(id);
		if(!ObjectUtils.isEmpty(propertyVo)) {
			checked=true;
		}
		return checked;
	}
	

	
}
