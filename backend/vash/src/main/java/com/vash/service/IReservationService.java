package com.vash.service;

import java.util.List;

import com.vash.domaine.ReservationVo;

public interface IReservationService {

	ReservationVo save(ReservationVo reservationVo);
	List<ReservationVo> findAll();
}
