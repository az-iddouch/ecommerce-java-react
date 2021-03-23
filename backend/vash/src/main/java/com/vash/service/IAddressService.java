package com.vash.service;

import java.util.List;

import com.vash.domaine.AddressVo;
import com.vash.entities.Address;

public interface IAddressService {

	Address save(AddressVo addressVo);
	List<AddressVo> findAll();
	
}
