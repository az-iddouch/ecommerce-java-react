package com.vash.domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVo {
	
	private Long id;
	private Double note;
	private String comment;

	private UserVo user;
	private PropertyVo property;
}
