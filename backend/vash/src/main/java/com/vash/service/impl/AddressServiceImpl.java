package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.IAddressRepository;
import com.vash.domaine.AddressConverter;
import com.vash.domaine.AddressVo;
import com.vash.service.IAddressService;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private IAddressRepository iAddressRepository;
	@Override
	public AddressVo save(AddressVo addressVo) {
		
		return AddressConverter.toVo(iAddressRepository.save(AddressConverter.toBo(addressVo)));
	}

	@Override
	public List<AddressVo> findAll() {
		return AddressConverter.toListVo(iAddressRepository.findAll());
	}

}
