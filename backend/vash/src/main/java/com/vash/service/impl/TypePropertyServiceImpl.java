package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.ITypePropertyRepository;
import com.vash.domaine.TypePropertyConverter;
import com.vash.domaine.TypePropertyVo;
import com.vash.entities.TypeProperty;
import com.vash.security.aop.LogTracer;
import com.vash.service.ITypePropertyService;

@Service
@Transactional
public class TypePropertyServiceImpl implements ITypePropertyService {
	@Autowired
	private ITypePropertyRepository iTypePropertyRepository;

	@Override
	@LogTracer
	public TypePropertyVo save(TypePropertyVo typePropertyVo) {
		return TypePropertyConverter.toVo(iTypePropertyRepository.save(TypePropertyConverter.toBo(typePropertyVo)));
	}

	@Override
	@LogTracer
	public List<TypePropertyVo> findAll() {
		return TypePropertyConverter.toListVo(iTypePropertyRepository.findAll());
	}

	@Override
	@LogTracer
	public TypePropertyVo findById(Long id) {
		Optional<TypeProperty> TypePropertyOptional = iTypePropertyRepository.findById(id);
		TypePropertyVo TypePropertyVo = new TypePropertyVo();
		if (TypePropertyOptional.isPresent()) {
			TypePropertyVo = TypePropertyConverter.toVo(TypePropertyOptional.get());
		}
		return TypePropertyVo;
	}

	@Override
	@LogTracer
	public boolean deleteById(Long id) {
		boolean checked = true;
		iTypePropertyRepository.deleteById(id);
		TypePropertyVo TypePropertyVo = findById(id);
		if (!ObjectUtils.isEmpty(TypePropertyVo)) {
			checked = true;
		}
		return checked;
	}

}
