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
public class PropertyVo  implements Serializable{

	private static final long serialVersionUID = 2800576072596357792L;
	private Long id;
	private String description;
	private Double price;
	private Boolean equiped;
	private String surface;
	private Integer numberRoom;
	private Integer numberWC;
	private Boolean visible;
	private Integer numberMaxPersons;

	private UserVo user;

	private TypePropertyVo typeProperty;

	private List<ImageVo> images;

	private List<TagsVo> tags;

	private AddressVo address;

	private List<ReservationVo> reservations;

	private List<ReviewVo> reviews;
	
	private CityVo city;
}
