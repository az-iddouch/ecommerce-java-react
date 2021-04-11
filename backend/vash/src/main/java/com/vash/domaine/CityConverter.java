package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.City;

public class CityConverter {

	public static City toBo(CityVo cityVo) {
		City city = null;
		if (!ObjectUtils.isEmpty(cityVo)) {
			city = new City();
			city.setId(cityVo.getId());
			city.setNameCity(cityVo.getNameCity());
			//city.setCountry(CountryConverter.toBo(cityVo.getCountry()));
			city.setUrl(cityVo.getUrl());
		}

		return city;
	}

	public static CityVo toVo(City city) {
		CityVo cityVo = null;
		if (!ObjectUtils.isEmpty(city)) {
			cityVo = new CityVo();
			cityVo.setId(city.getId());
			cityVo.setNameCity(city.getNameCity());
			//cityVo.setCountry(CountryConverter.toVo(city.getCountry()));
			cityVo.setUrl(city.getUrl());
		}

		return cityVo;
	}
	
	public static List<CityVo> toListVo(List<City> citys) {
		List<CityVo> cityVos = new ArrayList<CityVo>();
		if (!ObjectUtils.isEmpty(citys)) {
			for (City city : citys) {
				cityVos.add(toVo(city));
			}
		}

		return cityVos;
	}
	
	
	public static List<City> toListBo(List<CityVo> cityVos) {
		List<City> citys = new ArrayList<City>();
		if (!ObjectUtils.isEmpty(cityVos)) {
			for (CityVo cityVo : cityVos) {
				citys.add(toBo(cityVo));
			}
		}

		return citys;
	}
}
