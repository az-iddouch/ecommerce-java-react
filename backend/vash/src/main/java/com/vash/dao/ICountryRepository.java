package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Country;

public interface ICountryRepository extends JpaRepository<Country, Long>{

}
