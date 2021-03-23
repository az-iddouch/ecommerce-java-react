package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.User;

public class UserConverter {

	public static User toBo(UserVo userVo) {
		User user = null;
		if (!ObjectUtils.isEmpty(userVo)) {
			user = new User();
			user.setEmail(userVo.getEmail());
			user.setFirstName(userVo.getFirstName());
			user.setUserName(userVo.getUserName());
			user.setId(userVo.getId());
			user.setLastName(userVo.getLastName());
			user.setPassword(userVo.getPassword());
			user.setPhoneNumber1(userVo.getPhoneNumber1());
			user.setPhoneNumber2(userVo.getPhoneNumber2());
			user.setImage(ImageConverter.toBo(userVo.getImage()));
			user.setPropertys(PropertyConvert.toListBo(userVo.getPropertys()));
			user.setReservations(ReservationConvert.toListBo(userVo.getReservations()));
			user.setReviews(ReviewConverter.toListBo(userVo.getReviews()));
			user.setRoles(RoleConverter.toListBo(userVo.getRoles()));
		}

		return user;
	}

	public static UserVo toVo(User user) {
		UserVo userVo = null;
		if (!ObjectUtils.isEmpty(user)) {
			userVo = new UserVo();
			userVo.setEmail(user.getEmail());
			userVo.setFirstName(user.getFirstName());
			userVo.setUserName(user.getUserName());
			userVo.setId(user.getId());
			userVo.setLastName(user.getLastName());
			userVo.setPassword(user.getPassword());
			userVo.setPhoneNumber1(user.getPhoneNumber1());
			userVo.setPhoneNumber2(user.getPhoneNumber2());
			userVo.setImage(ImageConverter.toVo(user.getImage()));
			userVo.setPropertys(PropertyConvert.toListVo(user.getPropertys()));
			userVo.setReservations(ReservationConvert.toListVo(user.getReservations()));
			userVo.setReviews(ReviewConverter.toListVo(user.getReviews()));
			userVo.setRoles(RoleConverter.toListVo(user.getRoles()));
		}

		return userVo;
	}

	public static List<UserVo> toListVo(List<User> users) {
		List<UserVo> userVos = new ArrayList<UserVo>();
		if (!ObjectUtils.isEmpty(users)) {
			for (User user : users) {
				userVos.add(toVo(user));
			}
		}

		return userVos;
	}

	public static List<User> toListBo(List<UserVo> userVos) {
		List<User> users = new ArrayList<User>();
		if (!ObjectUtils.isEmpty(userVos)) {
			for (UserVo userVo : userVos) {
				users.add(toBo(userVo));
			}
		}

		return users;
	}

}
