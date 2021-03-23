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
public class AddressVo implements Serializable{

	private static final long serialVersionUID = 8206748478307904615L;
	private Long id;
	private String address;

	private PropertyVo property;

	private CityVo city;
}
