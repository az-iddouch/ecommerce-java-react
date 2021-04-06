package com.vash.service;

import java.util.List;

import com.vash.domaine.AddressVo;

public interface IAddressService {

	AddressVo save(AddressVo addressVo);
	List<AddressVo> findAll();
	AddressVo findById(Long id);
	boolean deleteById(Long id);
}
