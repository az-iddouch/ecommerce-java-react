package com.vash.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.ICityRepository;
import com.vash.domaine.CityConverter;
import com.vash.domaine.CityVo;
import com.vash.service.ICityService;
import com.vash.service.IPropertyService;

@Service
@Transactional
public class CityServiceImpl implements ICityService {

	@Autowired
	private ICityRepository iCityRepository;
	@Autowired
	private IPropertyService iPropertyService;

	@Override
	public CityVo save(CityVo cityVo) {
		return CityConverter.toVo(iCityRepository.save(CityConverter.toBo(cityVo)));
	}

	@Override
	public List<CityVo> findAll() {
		return CityConverter.toListVo(iCityRepository.findAll());
	}

	@Override
	public List<CityVo> findByNameCityIgnoreCaseContaining(String namecity) {
		return CityConverter.toListVo(iCityRepository.findByNameCityIgnoreCaseContaining(namecity));
	}

	@Override
	public Map<CityVo, Integer> countPropertyByCity(String nameCountry) {
		Map<CityVo, Integer> maps = new HashMap<CityVo, Integer>();
		List<CityVo> cityVos = new ArrayList<CityVo>();
		cityVos = findByCountryNameCountry(nameCountry);
		if (!ObjectUtils.isEmpty(cityVos)) {
			for (CityVo cityVo : cityVos) {
				maps.put(cityVo, iPropertyService.countPropertyInCity(cityVo));
			}
		}
		return maps;
	}

	@Override
	public CityVo findByNameCityIgnoreCase(String namecity) {
		return CityConverter.toVo(iCityRepository.findByNameCityIgnoreCase(namecity));
	}


	@Override
	public List<CityVo> findByCountryNameCountry(String nameCountry) {
		return CityConverter.toListVo(iCityRepository.findByCountryNameCountry(nameCountry));
	}

}
