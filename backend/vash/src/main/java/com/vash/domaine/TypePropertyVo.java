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

public class TypePropertyVo implements Serializable{

	private static final long serialVersionUID = 1912186718261904077L;
	private Long id;
	private String type;

	private List<PropertyVo> propertys;
}
