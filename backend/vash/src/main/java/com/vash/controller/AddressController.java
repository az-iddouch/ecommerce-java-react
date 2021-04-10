package com.vash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.AddressVo;
import com.vash.service.IAddressService;

@RestController
@RequestMapping(value="/api/address")
public class AddressController {

	@Autowired
	private IAddressService iAddressService;

	@PostMapping(value = "/save")
	public ResponseEntity<Object> save(@RequestBody AddressVo addressVo) {

		return new ResponseEntity<>(iAddressService.save(addressVo), HttpStatus.CREATED);
	}
}
