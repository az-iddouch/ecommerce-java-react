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

public class TypePropertyVo {

	private Long id;
	private String type;

	private List<PropertyVo> propertys;
}
