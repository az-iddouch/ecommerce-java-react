package com.vash.service;

import java.util.List;

import com.vash.domaine.TypePropertyVo;
import com.vash.entities.TypeProperty;

public interface ITypePropertyService {

	TypeProperty save (TypePropertyVo typePropertyVo);
	List<TypePropertyVo> findAll();
	
}
