package com.vash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Property;

public interface IPropertyRepository extends JpaRepository<Property, Long>{

	List<Property> findByUserUserName(String userName);
	List<Property> findByCityNameCity(String nameCity);
	List<Property> findByCityNameCityAndVisibleTrue(String nameCity);
	List<Property> findByCityNameCityAndVisibleTrueAndNumberMaxPersons(String nameCity,Integer numberMaxPersons);
}
