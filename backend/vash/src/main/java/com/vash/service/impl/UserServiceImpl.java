package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.IUserRepository;
import com.vash.domaine.UserConverter;
import com.vash.domaine.UserVo;
import com.vash.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserRepository iUserRepository;
	@Override
	public UserVo save(UserVo userVo) {
		return UserConverter.toVo(iUserRepository.save(UserConverter.toBo(userVo)));
	}

	@Override
	public List<UserVo> findAll() {
		return UserConverter.toListVo(iUserRepository.findAll());
	}

	@Override
	public UserVo findByUserNameAndPassword(String userName, String password) {
		
		return UserConverter.toVo(iUserRepository.findByUserNameAndPassword(userName, password));
	}

	
	
	
}
