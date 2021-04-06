package com.vash.service;

import java.util.List;

import com.vash.domaine.CountryVo;

public interface ICountryService {

	CountryVo save(CountryVo countryVo);
	List<CountryVo> findAll();
	CountryVo findById(Long id);
	boolean deleteById(Long id);
}
