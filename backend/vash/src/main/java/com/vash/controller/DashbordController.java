package com.vash.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vash.domaine.PropertyVo;
import com.vash.domaine.UserVo;
import com.vash.service.IPropertyService;
import com.vash.service.IUserService;

@RestController
@RequestMapping(value = "/api/dashboard")
public class DashbordController {
	@Autowired
	private IUserService iUserService;

	@Autowired
	private IPropertyService iPropertyService;
	
	@GetMapping("/")
	public ResponseEntity<?> dashboard(Principal principal){
		List<PropertyVo> propertyVos=new ArrayList<PropertyVo>();
		UserVo userVo=iUserService.findByUserName(principal.getName());
		if(!ObjectUtils.isEmpty(userVo)) {
			propertyVos=iPropertyService.findByUserId(userVo.getId());
		}
		return ResponseEntity.ok().body(propertyVos);
	}
}
