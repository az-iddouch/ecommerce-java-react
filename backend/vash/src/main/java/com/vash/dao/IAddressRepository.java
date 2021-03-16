package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Address;

public interface IAddressRepository extends JpaRepository<Address, Long>{

}
