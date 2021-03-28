package com.vash.domaine;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityVo implements Serializable{


	private static final long serialVersionUID = -4636383004887261393L;
	private Long id;
	private String nameCity;
	
	private AddressVo address;
	
	private CountryVo country;
	
	private List<PropertyVo> propertyVos;
}
