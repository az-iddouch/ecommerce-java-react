package com.vash.domaine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageVo  {

	private Long id;
	private String url;

	private PropertyVo property;

	private UserVo user;

	private TagsVo tag;
}
