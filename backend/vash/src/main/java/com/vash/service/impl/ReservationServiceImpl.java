package com.vash.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IReservationRepository;
import com.vash.domaine.CityVo;
import com.vash.domaine.CountryVo;
import com.vash.domaine.PropertyVo;
import com.vash.domaine.ReservationConvert;
import com.vash.domaine.ReservationVo;
import com.vash.entities.Reservation;
import com.vash.service.ICityService;
import com.vash.service.IPropertyService;
import com.vash.service.IReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	private IReservationRepository iReservationRepository;
	@Autowired
	private IPropertyService iPropertyService;
	@Autowired
	private ICityService iCityService;
	
	@Override
	public ReservationVo save(ReservationVo reservationVo) {
		return ReservationConvert.toVo(iReservationRepository.save(ReservationConvert.toBo(reservationVo)));
	}

	@Override
	public List<ReservationVo> findAll() {
		return ReservationConvert.toListVo(iReservationRepository.findAll());
	}

	@Override
	public List<ReservationVo> findByPropertyId(Long idProperty) {
		return ReservationConvert.toListVo(iReservationRepository.findByPropertyId(idProperty));
	}

	
	@Override
	public Integer countReservationByProperty(CityVo cityVo) {
		Integer count=0;
		List<PropertyVo> propertyVos=new ArrayList<PropertyVo>();
		propertyVos=iPropertyService.findByCityNameCity(cityVo.getNameCity());
		if(!ObjectUtils.isEmpty(propertyVos)) {
			for (PropertyVo propertyVo : propertyVos) {
				if(!ObjectUtils.isEmpty(propertyVo) && !ObjectUtils.isEmpty(propertyVo.getReservations())) {
					count=count+propertyVo.getReservations().size();
				}
			}
		}
		return count;
	}
	
	@Override
	public Map<CityVo, Integer> countReservationByCity(CountryVo countryVo) {
		Map<CityVo, Integer> maps = new HashMap<CityVo, Integer>();
		List<CityVo> cityVos = new ArrayList<CityVo>();

		if (!ObjectUtils.isEmpty(countryVo)) {
			cityVos = iCityService.findByCountryNameCountry(countryVo.getNameCountry());

			if (!ObjectUtils.isEmpty(cityVos)) {

				for (CityVo cityVo : cityVos) {
					maps.put(cityVo, countReservationByProperty(cityVo));
				}
			}
		}
		return maps;
	}

	@Override
	public ReservationVo findById(Long id) {
		Optional<Reservation> reservationOptional=iReservationRepository.findById(id);
		ReservationVo reservationVo=new ReservationVo();
		if(reservationOptional.isPresent()) {
			reservationVo=ReservationConvert.toVo(reservationOptional.get());
		}
		return reservationVo;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean checked=true;
		iReservationRepository.deleteById(id);
		ReservationVo reservationVo= findById(id);
		if(!ObjectUtils.isEmpty(reservationVo)) {
			checked=true;
		}
		return checked;
	}

	
}
