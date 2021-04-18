package com.vash.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vash.domaine.UserVo;
import com.vash.entities.EStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<?> save(Principal principal, @RequestParam(value="numberPersons")String numberPersons,@RequestParam(value="dateStart")Date dateStart,@RequestParam(value="dateEnd") Date dateEnd, @RequestParam(value="idProperty")String idProperty){

		UserVo loggedInUser = iUserService.findByUserName(principal.getName());
		ReservationVo reservationVo=new ReservationVo();
		reservationVo.setDateEnd((dateEnd));
		reservationVo.setStatus(EStatus.PENDING.name());
		reservationVo.setDateStart(dateStart);
		reservationVo.setNumberPersons(Integer.valueOf(numberPersons));
		reservationVo.setUser(loggedInUser);
		reservationVo.setProperty(iPropertyService.findById(Long.valueOf(idProperty)));
		ReservationVo created = iReservationService.save(reservationVo);
		if(created != null) {
			return ResponseEntity.created(null).body(created);
		}

		return ResponseEntity.badRequest().body(null);
	}
	
	public String  recupUserName(Principal principal){
		String username="";
		if(!ObjectUtils.isEmpty(principal)) {
			username=principal.getName();
		}
		return username;
	}
	
	// find Reservation By PropertyId
	@GetMapping(value="/byidproperty/{id}")
	public ResponseEntity<?> findReservationByPropertyId(@PathVariable(value="id") String id){
		List<ReservationVo> reservationVos = new ArrayList<ReservationVo>();
		if(!ObjectUtils.isEmpty(id)){
			reservationVos = iReservationService.findByPropertyId(Long.valueOf(id));
		}
		return  ResponseEntity.ok().body(reservationVos);
	}
	
}
