package com.vash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.City;

public interface ICityRepository extends JpaRepository<City, Long>{

	List<City> findByCountryNameCountry(String country);
	
	
}
