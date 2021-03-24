package com.vash.service;

import java.util.List;

import com.vash.domaine.PropertyVo;

public interface IPropertyService {

	PropertyVo save(PropertyVo PropertyVo);
	List<PropertyVo> findAll();
}
