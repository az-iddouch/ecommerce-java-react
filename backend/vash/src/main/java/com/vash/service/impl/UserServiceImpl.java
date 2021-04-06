package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IUserRepository;
import com.vash.domaine.UserConverter;
import com.vash.domaine.UserVo;
import com.vash.entities.User;
import com.vash.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

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

	@Override
	public UserVo findById(Long id) {
		Optional<User> UserOptional = iUserRepository.findById(id);
		UserVo userVo = new UserVo();
		if (UserOptional.isPresent()) {
			userVo = UserConverter.toVo(UserOptional.get());
		}
		return userVo;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean checked = true;
		iUserRepository.deleteById(id);
		UserVo userVo = findById(id);
		if (!ObjectUtils.isEmpty(userVo)) {
			checked = true;
		}
		return checked;
	}

}
