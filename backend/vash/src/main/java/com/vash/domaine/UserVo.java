package com.vash.domaine;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo implements Serializable{

	private static final long serialVersionUID = 5196377636866067347L;
	private Long id;
	@NotBlank(message = "First name field is required")
	private String firstName;
	@NotBlank(message = "Last name field is required")
	private String lastName;
	@Email(message = "You have to provide a valid email")
	@NotBlank(message= "Email is required")
	private String email;
	@NotBlank(message = "Username field is required")
	private String userName;
	@NotBlank(message = "Password field is required")
	private String password;
	@NotBlank(message = "Phone number field is required")
	private String phoneNumber1;
	private String phoneNumber2;

	private List<RoleVo> roles;

	private List<PropertyVo> propertys;

	private ImageVo image;

	private List<ReservationVo> reservations;

	private List<ReviewVo> reviews;

}
