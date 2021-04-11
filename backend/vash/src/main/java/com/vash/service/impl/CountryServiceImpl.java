package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.ICountryRepository;
import com.vash.domaine.CountryConverter;
import com.vash.domaine.CountryVo;
import com.vash.entities.Country;
import com.vash.security.aop.LogTracer;
import com.vash.service.ICountryService;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService{

	@Autowired
	private ICountryRepository iCountryRepository;

	@Override
	@LogTracer
	public CountryVo save(CountryVo countryVo) {
		return CountryConverter.toVo(iCountryRepository.save(CountryConverter.toBo(countryVo)));
	}

	@Override
	@LogTracer
	public List<CountryVo> findAll() {
		return CountryConverter.toListVo(iCountryRepository.findAll());
	}

	@Override
	@LogTracer
	public CountryVo findById(Long id) {
		Optional<Country> CountryOptional=iCountryRepository.findById(id);
		CountryVo countryVo=new CountryVo();
		if(CountryOptional.isPresent()) {
			countryVo=CountryConverter.toVo(CountryOptional.get());
		}
		return countryVo;
	}

	@Override
	@LogTracer
	public boolean deleteById(Long id) {
		boolean checked=true;
		iCountryRepository.deleteById(id);
		CountryVo countryVo= findById(id);
		if(!ObjectUtils.isEmpty(countryVo)) {
			checked=true;
		}
		return checked;
	}
}
