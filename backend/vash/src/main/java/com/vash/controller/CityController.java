package com.vash.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.CityVo;
import com.vash.domaine.VTopEightVilleVo;
import com.vash.service.ICityService;
import com.vash.service.IVTopEightVilleService;

@RestController
@CrossOrigin(origins = "*", maxAge = 36000000)
@RequestMapping(value="/api/city")
public class CityController {

	@Autowired
	private ICityService iCityService;
	@Autowired
	private IVTopEightVilleService iVTopEightVilleService;

	@PostMapping(value = "/save")
	public ResponseEntity<?> save(@RequestBody CityVo cityVo) {

		CityVo cityVop = iCityService.save(cityVo);
		return  ResponseEntity.ok().body(cityVop);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll() {

		List<CityVo> cityVos = iCityService.findAll();
		return  ResponseEntity.ok().body(cityVos);
	}
	//findByNameCityIgnoreCaseContaining %...%
	@GetMapping(value = "/autocompilation")
	public ResponseEntity<?> findByNameCityIgnoreCaseContaining(@PathVariable (value="nameCity") String namecity) {
		List<CityVo> cityVos =new ArrayList<CityVo>();
		cityVos = iCityService.findByNameCityIgnoreCaseContaining(namecity);
		return ResponseEntity.ok().body(cityVos);
	}
// search by namecity return  CityVo
	@GetMapping(value = "/serachByNameCity")
	public ResponseEntity<?> findByNameCityIgnore(@PathVariable (value="nameCity") String namecity) {
		CityVo cityVo  = iCityService.findByNameCityIgnoreCase(namecity);
	
		return ResponseEntity.ok().body(cityVo);
	}
	
	@GetMapping(value = "/serachCityByNameCountry")
	public ResponseEntity<?> findByCountryNameCountry(@PathVariable (value="nameCountry") String nameCountry) {
		List<CityVo> cityVos =new ArrayList<CityVo>();
		cityVos= iCityService.findByCountryNameCountry(nameCountry);
		
		return  ResponseEntity.ok().body(cityVos);
	}
	//countPropertyByCity
	@GetMapping(value = "/countPropertyByCity")
	public ResponseEntity<?> countPropertyByCity(@PathVariable (value="nameCountry") String nameCountry) {
		Map<CityVo,Integer> maps=new HashMap<CityVo, Integer>();
		maps= iCityService.countPropertyByCity(nameCountry);
		return  ResponseEntity.ok().body(maps);
	}

	@GetMapping(value = "/vTopEightVilleVo")
	public ResponseEntity<?> findAllvTopEightVilleVo() {
		List<VTopEightVilleVo> vTopEightVilleVos=new ArrayList<VTopEightVilleVo>();
		vTopEightVilleVos = iVTopEightVilleService.findAll();
		return  ResponseEntity.ok().body(vTopEightVilleVos);
	}
}
