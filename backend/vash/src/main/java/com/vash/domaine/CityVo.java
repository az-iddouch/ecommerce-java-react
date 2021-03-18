package com.vash.domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityVo {

	private Long id;
	private String nameCity;
	
	private AddressVo address;
	
	private CountryVo country;
}
