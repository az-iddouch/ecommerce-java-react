package com.vash.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.ReservationVo;
import com.vash.service.IPropertyService;
import com.vash.service.IReservationService;
import com.vash.service.IUserService;

@RestController
@RequestMapping(value="/api/reservation")
public class ReservationController {

	@Autowired
	private IReservationService iReservationService;
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IPropertyService iPropertyService;
	
	@PostMapping(value="/save")
	public ResponseEntity<Object> save(@RequestParam(value="numberPersons")String numberPersons,@RequestParam(value="dateStart")Date dateStart,@RequestParam(value="dateEnd") Date dateEnd,@RequestParam(value="status")String status,@RequestParam(value="idProperty")String idProperty,@RequestParam(value="idUser")String idUser){

		ReservationVo reservationVo=new ReservationVo();
		reservationVo.setDateEnd((dateEnd));
		reservationVo.setStatus(status);
		reservationVo.setDateStart(dateStart);
		reservationVo.setNumberPersons(Integer.valueOf(numberPersons));
		reservationVo.setUser(iUserService.findById(Long.valueOf(idUser)));
		reservationVo.setProperty(iPropertyService.findById(Long.valueOf(idProperty)));
		
		if(ObjectUtils.isEmpty(iReservationService.save(reservationVo))){
			return new ResponseEntity<>("Reservation is created successfully", HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>("Reservation isn't created ", HttpStatus.CREATED);
	}
	
	public String  recupUserName(Principal principal){
		String username="";
		if(!ObjectUtils.isEmpty(principal)) {
			username=principal.getName();
		}
		return username;
	}
	
	
	
	
}
