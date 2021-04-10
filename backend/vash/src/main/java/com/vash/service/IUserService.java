package com.vash.service;

import java.util.List;

import com.vash.domaine.LoginPayload;
import com.vash.domaine.UserVo;

public interface IUserService {

	LoginPayload register(UserVo userVo);
	List<UserVo> findAll();
	UserVo findByUserNameAndPassword(String userName,String password);
	UserVo findById(Long id);
	boolean deleteById(Long id);
    LoginPayload login(String username, String password);
}
