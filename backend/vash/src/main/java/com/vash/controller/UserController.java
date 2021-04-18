package com.vash.controller;

import java.security.Principal;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.LoginPayload;
import com.vash.domaine.UserVo;
import com.vash.service.IUserService;
import com.vash.utils.ErrorValidation;

@RestController
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
		return ResponseEntity.ok().body(iUserService.login(username, password));
	}

	@PostMapping(value="/search")
	public ResponseEntity<Object> search(@RequestBody UserVo userVo){
		if(ObjectUtils.isEmpty(userVo)) {
			return  ResponseEntity.ok("error is empty");
		}
		UserVo user=iUserService.findByUserNameAndPassword(userVo.getUserName(), userVo.getPassword());
		if(ObjectUtils.isEmpty(user)) {
			return  ResponseEntity.ok().body("doesn't exist");
		}
		return  ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/test")
	public ResponseEntity<?> test(Principal principal){
		return ResponseEntity.ok(principal.getName());
	}

}
