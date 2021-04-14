package com.vash.controller;

import java.security.Principal;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.vash.domaine.LoginPayload;
import com.vash.domaine.UserVo;
import com.vash.service.IUserService;
import com.vash.utils.ErrorValidation;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping(value= "/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserVo userVo, BindingResult result){
		ResponseEntity<Map<String, String>> errorMap = ErrorValidation.getValidationErrorMap(result);
		if(errorMap != null){
			return errorMap;
		}
		return ResponseEntity.created(null).body(iUserService.register(userVo));
	}


	@PostMapping(value = "/login")
	public ResponseEntity<LoginPayload> login(@RequestParam(name = "userName") String username, @RequestParam(name = "password") String password) {
		log.info("username :" + username );

		return ResponseEntity.ok().body(iUserService.login(username, password));
	}

	@PostMapping(value="/search")
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

	@GetMapping(value = "/test")
	public ResponseEntity<?> test(Principal principal){
		return ResponseEntity.ok(principal.getName());
	}

}
