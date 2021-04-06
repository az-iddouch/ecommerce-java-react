package com.vash.service;

import java.util.List;

import com.vash.domaine.TypePropertyVo;

public interface ITypePropertyService {

	TypePropertyVo save (TypePropertyVo typePropertyVo);
	List<TypePropertyVo> findAll();
	TypePropertyVo findById(Long id);
	boolean deleteById(Long id);
}
