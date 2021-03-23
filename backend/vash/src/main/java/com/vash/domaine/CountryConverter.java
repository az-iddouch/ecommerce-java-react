package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Country;

public class CountryConverter {

	public static Country toBo(CountryVo countryVo) {
		Country country = null;
		if (!ObjectUtils.isEmpty(countryVo)) {
			country = new Country();
			country.setId(countryVo.getId());
			country.setNameCountry(countryVo.getNameCountry());
			country.setCity(CityConverter.toBo(countryVo.getCity()));
		}

		return country;
	}

	public static CountryVo toVo(Country country) {
		CountryVo countryVo = null;
		if (!ObjectUtils.isEmpty(country)) {
			countryVo = new CountryVo();
			countryVo.setId(country.getId());
			countryVo.setNameCountry(country.getNameCountry());
			countryVo.setCity(CityConverter.toVo(country.getCity()));
		}

		return countryVo;
	}

	public static List<Country> toListBo(List<CountryVo> countryVos) {
		List<Country> countrys = new ArrayList<Country>();
		if (!ObjectUtils.isEmpty(countryVos)) {
			for (CountryVo country : countryVos) {
				countrys.add(toBo(country));
			}
		}

		return countrys;
	}

	public static List<CountryVo> toListVo(List<Country> countryBos) {
		List<CountryVo> countryVos = new ArrayList<CountryVo>();
		if (!ObjectUtils.isEmpty(countryBos)) {
			for (Country country : countryBos) {
				countryVos.add(toVo(country));
			}
		}

		return countryVos;
	}
}
