package com.vash.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.PropertyVo;
import com.vash.service.IPropertyService;

@RestController
public class PropertyController {

	@Autowired
	private IPropertyService iPropertyService;

	@PostMapping(value = "/rest/property/save")
	public ResponseEntity<Object> save(@Valid @RequestBody PropertyVo propertyVo) {
		iPropertyService.save(propertyVo);
		return new ResponseEntity<>("Property is created successfully", HttpStatus.CREATED);
	}

	// findAll
	@GetMapping(value = "/rest/property")
	public ResponseEntity<Object> findAll() {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		propertyVos = iPropertyService.findAll();
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

	@GetMapping(value = "/rest/property/{nameCity}")
	public ResponseEntity<Object> findByCityNameCity(@PathVariable(value = "nameCity") String nameCity) {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		propertyVos = iPropertyService.findByCityNameCity(nameCity);
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

	// findByCityNameCityAndVisibleTrue
	@GetMapping(value = "/rest/propertyVisible/{nameCity}")
	public ResponseEntity<Object> find(@PathVariable(value = "nameCity") String nameCity) {

		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		propertyVos = iPropertyService.findByCityNameCityAndVisibleTrue(nameCity);
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

	@GetMapping(value = "/rest/propertyVisible/{nameCity}/{numberMaxPersons}")
	public ResponseEntity<Object> find(@PathVariable(value = "nameCity") String nameCity,
			@PathVariable(value = "numberMaxPersons") String numberMaxPersons) {

		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		propertyVos = iPropertyService.findByCityNameCityAndVisibleTrueAndNumberMaxPersons(nameCity,
				Integer.valueOf(numberMaxPersons));
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

}
