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
public class TagsVo implements Serializable{

	private static final long serialVersionUID = 9051539969733133906L;
	private Long id;
	private String nameTag;

	private List<PropertyVo> propertys;

	private ImageVo image;

}
