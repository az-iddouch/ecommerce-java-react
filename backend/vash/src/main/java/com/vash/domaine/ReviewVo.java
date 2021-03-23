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
public class ReviewVo implements Serializable{
	
	
	private static final long serialVersionUID = 4649094439891541659L;
	private Long id;
	private Double note;
	private String comment;

	private UserVo user;
	private PropertyVo property;
}
