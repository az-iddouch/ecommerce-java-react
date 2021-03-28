package com.vash.service;

import java.util.List;
import java.util.Map;

import com.vash.domaine.CityVo;
import com.vash.domaine.CountryVo;
import com.vash.domaine.ReservationVo;

public interface IReservationService {

	ReservationVo save(ReservationVo reservationVo);
	List<ReservationVo> findAll();
	List<ReservationVo> findByPropertyId(Long idProperty);
	Integer countReservationByProperty(CityVo cityVo);
	
	Map<CityVo,Integer> countReservationByCity(CountryVo countryVo);
}
