package com.vash.service;

import java.util.List;

import com.vash.domaine.UserVo;

public interface IUserService {

	UserVo save(UserVo userVo);
	List<UserVo> findAll();
	UserVo findByUserNameAndPassword(String userName,String password);
	UserVo findById(Long id);
	boolean deleteById(Long id);
}
