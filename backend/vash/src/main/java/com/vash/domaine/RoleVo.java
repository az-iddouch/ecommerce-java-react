package com.vash.domaine;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RoleVo implements Serializable{
	
	private static final long serialVersionUID = 1110636648031304493L;
	private Long id;
	private String role;
}
