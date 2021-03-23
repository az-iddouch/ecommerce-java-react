package com.vash.service;

import java.util.List;

import com.vash.domaine.ReservationVo;
import com.vash.entities.Reservation;

public interface IReservationService {

	Reservation save(ReservationVo reservationVo);
	List<ReservationVo> findAll();
}
