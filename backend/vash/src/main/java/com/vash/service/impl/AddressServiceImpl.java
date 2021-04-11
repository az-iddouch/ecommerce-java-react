package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IAddressRepository;
import com.vash.domaine.AddressConverter;
import com.vash.domaine.AddressVo;
import com.vash.entities.Address;
import com.vash.security.aop.LogTracer;
import com.vash.service.IAddressService;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService{

	@Autowired
	private IAddressRepository iAddressRepository;
	@Override
	@LogTracer
	public AddressVo save(AddressVo addressVo) {
		
		return AddressConverter.toVo(iAddressRepository.save(AddressConverter.toBo(addressVo)));
	}

	@Override
	@LogTracer
	public List<AddressVo> findAll() {
		return AddressConverter.toListVo(iAddressRepository.findAll());
	}

	@Override
	@LogTracer
	public AddressVo findById(Long id) {
		Optional<Address> addressOptional=iAddressRepository.findById(id);
		AddressVo addressVo=new AddressVo();
		if(addressOptional.isPresent()) {
			addressVo=AddressConverter.toVo(addressOptional.get());
		}
		return addressVo;
	}

	@Override
	@LogTracer
	public boolean deleteById(Long id) {
		boolean checked=true;
		iAddressRepository.deleteById(id);
		AddressVo addressVo= findById(id);
		if(!ObjectUtils.isEmpty(addressVo)) {
			checked=true;
		}
		return checked;
	}

	
	
}
