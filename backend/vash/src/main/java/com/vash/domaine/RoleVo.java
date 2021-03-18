package com.vash.domaine;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoleVo {
	private Long id;
	private String role;
	
	private List<UserVo> users;
}
