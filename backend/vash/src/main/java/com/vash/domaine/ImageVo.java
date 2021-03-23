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
public class ImageVo  implements Serializable{

	private static final long serialVersionUID = -7788512918812029326L;
	private Long id;
	private String url;

	private PropertyVo property;

	private UserVo user;

	private TagsVo tag;
}
