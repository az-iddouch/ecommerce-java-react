package com.vash.service;

import java.util.List;

import com.vash.domaine.CountryVo;
import com.vash.entities.Country;

public interface ICountryService {

	Country save(CountryVo countryVo);
	List<CountryVo> findAll();

}
