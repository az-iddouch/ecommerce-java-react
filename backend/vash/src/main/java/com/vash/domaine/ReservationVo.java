package com.vash.domaine;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVo implements Serializable{

	private static final long serialVersionUID = 4234938753916436795L;
	private Long id;
	private Integer numberPersons;
	private Date dateStart;
	private Date dateEnd;
	private String status;
	
	private PropertyVo property;
	
	private UserVo user;
}
