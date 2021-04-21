package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Reservation;

public class ReservationConvert {
	/** user and property desactive **/
	public static Reservation toBo(ReservationVo reservationVo) {
		Reservation reservation = null;
		if (!ObjectUtils.isEmpty(reservationVo)) {
			reservation = new Reservation();
			reservation.setId(reservationVo.getId());
			reservation.setDateEnd(reservationVo.getDateEnd());
			reservation.setDateStart(reservationVo.getDateStart());
			reservation.setNumberPersons(reservationVo.getNumberPersons());
			reservation.setStatus(reservationVo.getStatus());
			// reservation.setProperty(PropertyConvert.toBo(reservationVo.getProperty()));
			// reservation.setUser(UserConverter.toBo(reservationVo.getUser()));
		}

		return reservation;
	}

	/** user and property desactive **/
	public static ReservationVo toVo(Reservation reservation) {
		ReservationVo reservationVo = null;
		if (!ObjectUtils.isEmpty(reservation)) {
			reservationVo = new ReservationVo();
			reservationVo.setId(reservation.getId());
			reservationVo.setDateEnd(reservation.getDateEnd());
			reservationVo.setDateStart(reservation.getDateStart());
			reservationVo.setNumberPersons(reservation.getNumberPersons());
			reservationVo.setStatus(reservation.getStatus());
//			reservationVo.setProperty(PropertyConvert.toVo(reservation.getProperty()));
//			reservationVo.setUser(UserConverter.toVo(reservation.getUser()));
		}

		return reservationVo;
	}

	/** user and property desactive **/
	public static List<Reservation> toListBo(List<ReservationVo> reservationVos) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		if (!ObjectUtils.isEmpty(reservationVos)) {
			for (ReservationVo reservationVo : reservationVos) {
				reservations.add(toBo(reservationVo));
			}

		}

		return reservations;
	}

	/** user and property desactive **/
	public static List<ReservationVo> toListVo(List<Reservation> reservations) {
		List<ReservationVo> reservationVos = new ArrayList<ReservationVo>();
		if (!ObjectUtils.isEmpty(reservations)) {
			for (Reservation reservation : reservations) {
				reservationVos.add(toVo(reservation));
			}
		}

		return reservationVos;
	}

	// ------------------------------------------
	/** user and property active **/
	public static Reservation toBo2(ReservationVo reservationVo) {
		Reservation reservation = null;
		if (!ObjectUtils.isEmpty(reservationVo)) {
			reservation = new Reservation();
			reservation.setId(reservationVo.getId());
			reservation.setDateEnd(reservationVo.getDateEnd());
			reservation.setDateStart(reservationVo.getDateStart());
			reservation.setNumberPersons(reservationVo.getNumberPersons());
			reservation.setStatus(reservationVo.getStatus());
			reservation.setProperty(PropertyConvert.toBo2(reservationVo.getProperty()));
			reservation.setUser(UserConverter.toBo3(reservationVo.getUser()));
		}

		return reservation;
	}

	/** user and property active **/
	public static ReservationVo toVo2(Reservation reservation) {
		ReservationVo reservationVo = null;
		if (!ObjectUtils.isEmpty(reservation)) {
			reservationVo = new ReservationVo();
			reservationVo.setId(reservation.getId());
			reservationVo.setDateEnd(reservation.getDateEnd());
			reservationVo.setDateStart(reservation.getDateStart());
			reservationVo.setNumberPersons(reservation.getNumberPersons());
			reservationVo.setStatus(reservation.getStatus());
			reservationVo.setProperty(PropertyConvert.toVo2(reservation.getProperty()));
			reservationVo.setUser(UserConverter.toVo3(reservation.getUser()));
		}

		return reservationVo;
	}

	/** user and property active **/
	public static List<Reservation> toListBo2(List<ReservationVo> reservationVos) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		if (!ObjectUtils.isEmpty(reservationVos)) {
			for (ReservationVo reservationVo : reservationVos) {
				reservations.add(toBo2(reservationVo));
			}

		}

		return reservations;
	}

	/** user and property active **/
	public static List<ReservationVo> toListVo2(List<Reservation> reservations) {
		List<ReservationVo> reservationVos = new ArrayList<ReservationVo>();
		if (!ObjectUtils.isEmpty(reservations)) {
			for (Reservation reservation : reservations) {
				reservationVos.add(toVo2(reservation));
			}
		}

		return reservationVos;
	}


	/** user active - dashboard **/
	public static ReservationVo toVoDashboard(Reservation reservation) {
		ReservationVo reservationVo = null;
		if (!ObjectUtils.isEmpty(reservation)) {
			reservationVo = new ReservationVo();
			reservationVo.setId(reservation.getId());
			reservationVo.setDateEnd(reservation.getDateEnd());
			reservationVo.setDateStart(reservation.getDateStart());
			reservationVo.setNumberPersons(reservation.getNumberPersons());
			reservationVo.setStatus(reservation.getStatus());
			reservationVo.setUser(UserConverter.toVo3(reservation.getUser()));
		}

		return reservationVo;
	}

	/** user active **/
	public static List<ReservationVo> toListVoDashboard(List<Reservation> reservations) {
		List<ReservationVo> reservationVos = new ArrayList<ReservationVo>();
		if (!ObjectUtils.isEmpty(reservations)) {
			for (Reservation reservation : reservations) {
				reservationVos.add(toVoDashboard(reservation));
			}
		}

		return reservationVos;
	}

}
