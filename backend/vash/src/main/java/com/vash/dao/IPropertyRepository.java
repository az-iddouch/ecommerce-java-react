package com.vash.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Property;

public interface IPropertyRepository extends JpaRepository<Property, Long>{

	List<Property> findByUserUserName(String userName);
	List<Property> findByCityId(Long idCity);
	List<Property> findByCityIdAndVisibleTrue(Long idCity);
	List<Property> findByCityIdAndVisibleTrueAndNumberMaxPersons(Long id,Integer numberMaxPersons);
	List<Property> findByTypePropertyId(Long id); 
	List<Property> findByUserId(Long id);
}
