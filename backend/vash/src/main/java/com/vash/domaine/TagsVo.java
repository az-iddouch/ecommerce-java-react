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
public class TagsVo {

	private Long id;
	private String nameTag;

	private List<PropertyVo> propertys;

	private ImageVo image;

}
