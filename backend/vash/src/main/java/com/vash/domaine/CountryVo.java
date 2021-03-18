package com.vash.domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryVo {

	private Long id;
	private String nameCountry;
	
	private CityVo city;
}
