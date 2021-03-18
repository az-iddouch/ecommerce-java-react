package com.vash.domaine;

import java.util.List;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

	private Long id;
	private String firstName;
	private String lastName;
	@Email(message = "She isn't @ mail")
	private String email;
	private String userName;
	private String password;
	private String phoneNumber1;
	private String phoneNumber2;

	private List<RoleVo> roles;

	private List<PropertyVo> propertys;

	private ImageVo image;

	private List<ReservationVo> reservations;

	private List<ReviewVo> reviews;

}
