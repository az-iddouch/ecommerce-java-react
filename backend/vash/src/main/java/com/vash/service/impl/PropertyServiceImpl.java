package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.IPropertyRepository;
import com.vash.domaine.PropertyConvert;
import com.vash.domaine.PropertyVo;
import com.vash.service.IPropertyService;

@Service
@Transactional
public class PropertyServiceImpl implements IPropertyService {
	
	@Autowired
	private IPropertyRepository IPropertyRepository;

	@Override
	public PropertyVo save(PropertyVo PropertyVo) {
		return PropertyConvert.toVo(IPropertyRepository.save(PropertyConvert.toBo(PropertyVo)));
	}

	@Override
	public List<PropertyVo> findAll() {
		return PropertyConvert.toListVo(IPropertyRepository.findAll());
	}

}
