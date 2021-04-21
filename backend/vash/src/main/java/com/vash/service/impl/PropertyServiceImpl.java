package com.vash.service.impl;

import java.util.ArrayList;
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
import com.vash.security.aop.LogTracer;
import com.vash.service.IPropertyService;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	private IPropertyRepository iPropertyRepository;

	@Override
	@LogTracer
	public PropertyVo save(PropertyVo PropertyVo) {
		return PropertyConvert.toVo(iPropertyRepository.save(PropertyConvert.toBo(PropertyVo)));
	}

	@Override
	@LogTracer
	public List<PropertyVo> findAll() {
		return PropertyConvert.toListVo(iPropertyRepository.findAll());
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByCityId(Long idCity) {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if (!ObjectUtils.isEmpty(idCity)) {
			propertyVos = PropertyConvert.toListVo(iPropertyRepository.findByCityId(idCity));
		}
		return propertyVos;
	}

	@Override
	@LogTracer
	public Integer countPropertyInCity(CityVo cityVo) {
		Integer count = 0;
		List<PropertyVo> propertyVos = findByCityId(cityVo.getId());
		if (!ObjectUtils.isEmpty(propertyVos)) {
			count = propertyVos.size();
		}
		return count;
	}

	@Override
	@LogTracer
	public PropertyVo findById(Long id) {
		PropertyVo propertyVo = null;
		Optional<Property> property = iPropertyRepository.findById(id);
		if (property.isPresent()) {
			propertyVo = PropertyConvert.toVo(property.get());
		}
		return propertyVo;
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByCityIdAndVisibleTrue(Long idCity) {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if (!ObjectUtils.isEmpty(idCity)) {
			propertyVos = PropertyConvert
					.toListVo(iPropertyRepository.findByCityIdAndVisibleTrue(idCity));
		}
		return propertyVos;
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByCityIdAndVisibleTrueAndNumberMaxPersons(Long idCity, Integer numberMaxPersons) {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if (!ObjectUtils.isEmpty(idCity) || !ObjectUtils.isEmpty(numberMaxPersons)) {
			propertyVos = PropertyConvert.toListVo(iPropertyRepository
					.findByCityIdAndVisibleTrueAndNumberMaxPersons(idCity, numberMaxPersons));
		}
		return propertyVos;
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByCityNameCityAndVisibleTrueAndBetweenDate(String nameCity, Date dateStart,
			Date dateEnd) {

		return null;
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByCityNameCityAndVisibleTrueAndNumberMaxPersonsBetweenDate(String nameCity,
			Integer numberMaxPersons, Date dateStart, Date dateEnd) {
		return null;
	}

	@Override
	@LogTracer
	public boolean deleteById(Long id) {
		boolean checked = true;
		iPropertyRepository.deleteById(id);
		PropertyVo propertyVo = findById(id);
		if (!ObjectUtils.isEmpty(propertyVo)) {
			checked = true;
		}
		return checked;
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByTypePropertyId(Long id) {
		return PropertyConvert.toListVo(iPropertyRepository.findByTypePropertyId(id));
	}

	@Override
	@LogTracer
	public List<PropertyVo> findByUserId(Long id) {
		return PropertyConvert.toListVoDashoard(iPropertyRepository.findByUserId(id));
	}

}
