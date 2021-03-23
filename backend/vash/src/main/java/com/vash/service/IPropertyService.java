package com.vash.service;

import java.util.List;

import com.vash.domaine.PropertyVo;
import com.vash.entities.Property;

public interface IPropertyService {

	Property save(PropertyVo PropertyVo);
	List<PropertyVo> findAll();
}
