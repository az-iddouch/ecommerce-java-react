package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.IReservationRepository;
import com.vash.domaine.ReservationConvert;
import com.vash.domaine.ReservationVo;
import com.vash.service.IReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	private IReservationRepository iReservationRepository;
	@Override
	public ReservationVo save(ReservationVo reservationVo) {
		return ReservationConvert.toVo(iReservationRepository.save(ReservationConvert.toBo(reservationVo)));
	}

	@Override
	public List<ReservationVo> findAll() {
		return ReservationConvert.toListVo(iReservationRepository.findAll());
	}

}
