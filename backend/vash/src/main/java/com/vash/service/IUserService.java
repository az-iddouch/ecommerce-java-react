package com.vash.service;

import java.util.List;

import com.vash.domaine.UserVo;
import com.vash.entities.User;

public interface IUserService {

	User save(UserVo userVo);
	List<UserVo> findAll();
}
