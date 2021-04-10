package com.vash.controller;

import com.vash.utils.ErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.UserVo;
import com.vash.service.IUserService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService iUserService;
	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@Valid @RequestBody UserVo userVo, BindingResult result){
		ResponseEntity<Map<String, String>> errorMap = ErrorValidation.getValidationErrorMap(result);
		if(errorMap != null){
			return errorMap;
		}

		return ResponseEntity.created(null).body(iUserService.save(userVo));
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
