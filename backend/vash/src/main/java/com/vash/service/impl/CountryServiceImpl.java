package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.ICountryRepository;
import com.vash.domaine.CountryConverter;
import com.vash.domaine.CountryVo;
import com.vash.service.ICountryService;

@Service
@Transactional
public class CountryServiceImpl implements ICountryService{

	@Autowired
	private ICountryRepository iCountryRepository;

	@Override
	public CountryVo save(CountryVo countryVo) {
		return CountryConverter.toVo(iCountryRepository.save(CountryConverter.toBo(countryVo)));
	}

	@Override
	public List<CountryVo> findAll() {
		return CountryConverter.toListVo(iCountryRepository.findAll());
	}
}
