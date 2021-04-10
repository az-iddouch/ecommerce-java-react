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
public class CountryVo implements Serializable{

	private static final long serialVersionUID = -464945677393190399L;
	private Long id;
	private String nameCountry;
	
}
