package com.vash.domaine;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VTopEightVilleVo implements Serializable {

	private static final long serialVersionUID = 7624931428711012618L;
	private Long cityId;
	private String nameCity;
	private Long countryId;
	private Integer counter;
	private String url;
}
