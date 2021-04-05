package com.vash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.UserVo;
import com.vash.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@PostMapping(value="/rest/user/save")
	public ResponseEntity<Object> save(@RequestBody UserVo userVo){
		if(ObjectUtils.isEmpty(userVo)) {
			return new ResponseEntity<>("doesn't exist",HttpStatus.OK);
		}
		return new ResponseEntity<>(iUserService.save(userVo),HttpStatus.OK);
	}
	
	@PostMapping(value="/rest/user/search")
	public ResponseEntity<Object> search(@RequestBody UserVo userVo){
		if(ObjectUtils.isEmpty(userVo)) {
			return new ResponseEntity<>("error is empty",HttpStatus.OK);
		}
		UserVo user=iUserService.findByUserNameAndPassword(userVo.getUserName(), userVo.getPassword());
		if(ObjectUtils.isEmpty(user)) {
			return new ResponseEntity<>("doesn't exist",HttpStatus.OK);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
