package com.vash.service;

import java.util.List;

import com.vash.domaine.TagsVo;

public interface ITagsService {

	TagsVo save(TagsVo tagsVo);
	List<TagsVo> findAll();
}
