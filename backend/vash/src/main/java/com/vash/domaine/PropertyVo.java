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
public class PropertyVo  {

	private Long id;
	private String description;
	private String price;
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
	
	
}
