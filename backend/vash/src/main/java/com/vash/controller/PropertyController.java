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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.PropertyVo;
import com.vash.service.IPropertyService;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyController {

	@Autowired
	private IPropertyService iPropertyService;
	

	@PostMapping(value = "/save")
	public ResponseEntity<Object> save(@Valid @RequestBody PropertyVo propertyVo) {
		iPropertyService.save(propertyVo);
		return new ResponseEntity<>("Property is created successfully", HttpStatus.CREATED);
	}

	// findAll
	@GetMapping(value = "/findAll")
	public ResponseEntity<Object> findAll() {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		propertyVos = iPropertyService.findAll();
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

//property je dis chercher par l'id dial city 
	@GetMapping(value = "/{idCity}")
	public ResponseEntity<Object> findByCityNameCity(@PathVariable(value = "idCity") String idCity) {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if (!ObjectUtils.isEmpty(idCity)) {
			propertyVos = iPropertyService.findByCityId(Long.valueOf(idCity));
		}
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

	// findByCityNameCityAndVisibleTrue
	@GetMapping(value = "/visible/{idCity}")
	public ResponseEntity<Object> find(@PathVariable(value = "idCity") String idCity) {

		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		propertyVos = iPropertyService.findByCityIdAndVisibleTrue(Long.valueOf(idCity));
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

	@GetMapping(value = "/visible/{idCity}/{numberMaxPersons}")
	public ResponseEntity<Object> find(@PathVariable(value = "idCity") String idCity,
			@PathVariable(value = "numberMaxPersons") String numberMaxPersons) {

		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if(!ObjectUtils.isEmpty(idCity) || !ObjectUtils.isEmpty(numberMaxPersons)) {
		propertyVos = iPropertyService.findByCityIdAndVisibleTrueAndNumberMaxPersons(Long.valueOf(idCity),
				Integer.valueOf(numberMaxPersons));
		}
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}

	@GetMapping(value="/typePropertyId/{id}")
	public ResponseEntity<Object> findByTypePropertyId(@PathVariable(value="id") String id){
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if(!ObjectUtils.isEmpty(id)){
			propertyVos = iPropertyService.findByTypePropertyId(Long.valueOf(id));
		}
		if (ObjectUtils.isEmpty(propertyVos)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVos, HttpStatus.OK);
	}
	 
}
