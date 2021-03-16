package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long>{

}
