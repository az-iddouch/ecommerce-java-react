package com.vash.domaine;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVo {

	private Long id;
	private Integer numberPersons;
	private Date dateStart;
	private Date dateEnd;
	private String status;
	
	private PropertyVo property;
	
	private UserVo user;
}
