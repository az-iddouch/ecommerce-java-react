package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.ITypePropertyRepository;
import com.vash.domaine.TypePropertyConverter;
import com.vash.domaine.TypePropertyVo;
import com.vash.service.ITypePropertyService;

@Service
@Transactional
public class TypePropertyServiceImpl implements ITypePropertyService {
	@Autowired
	private ITypePropertyRepository iTypePropertyRepository;

	@Override
	public TypePropertyVo save(TypePropertyVo typePropertyVo) {
		return TypePropertyConverter.toVo(iTypePropertyRepository.save(TypePropertyConverter.toBo(typePropertyVo)));
	}

	@Override
	public List<TypePropertyVo> findAll() {
		return TypePropertyConverter.toListVo(iTypePropertyRepository.findAll());
	}

}
