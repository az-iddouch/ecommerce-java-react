package com.vash.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.vash.domaine.PropertyVo;
import com.vash.service.IPropertyService;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyController {

//	@Autowired
//	private IUserService iUserService;
//	@Autowired
//	private ICityService iCityService;
	@Autowired
	private IPropertyService iPropertyService;
//	@Autowired
//	private ITypePropertyService iTypePropertyService;
	

	@PostMapping(value = "/save")
	public ResponseEntity<Object> save(@Valid @RequestBody String userid) {
//		CityVo cityVo=iCityService.findById(1L);
//		TypePropertyVo typePropertyVo=iTypePropertyService.findById(1L);
//		//TagsVo tagsVo= iTagsService.findAllByIds(ids);
//		UserVo userVo=new UserVo();
//		if(!ObjectUtils.isEmpty(userid)) {
//		userVo=iUserService.findById(Long.valueOf(userid));
//		}
//		AddressVo addressVo=new AddressVo();
//		addressVo.setAddress("ssssssssss");
		PropertyVo propertyVo =new PropertyVo();
//		propertyVo.setAddress(addressVo);
//		propertyVo.setTypeProperty(typePropertyVo);
//		propertyVo.setCity(cityVo);
//		if(!ObjectUtils.isEmpty(userVo)) {
//		propertyVo.setUser(userVo);
//		}
//		propertyVo.setDescription("hhhhhhhhhhhhhhhhhhhhhh");
//		propertyVo.setEquiped(true);
//		propertyVo.setNumberMaxPersons(2);
//		propertyVo.setNumberRoom(3);
//		propertyVo.setPrice(45.60);
//		propertyVo.setNumberWC(3);
//		propertyVo.setSurface("120m²");
//		propertyVo.setVisible(true);
//		iPropertyService.save(propertyVo);
//
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

	@GetMapping(value="/byid/{id}")
	public ResponseEntity<Object> findPropertyById(@PathVariable(value="id") String id){
		PropertyVo propertyVo = new PropertyVo();
		if(!ObjectUtils.isEmpty(id)){
			propertyVo = iPropertyService.findById(Long.valueOf(id));
		}
		if (ObjectUtils.isEmpty(propertyVo)) {
			return new ResponseEntity<>("doesn't exist", HttpStatus.OK);
		}
		return new ResponseEntity<>(propertyVo, HttpStatus.OK);
	}
	 
}
