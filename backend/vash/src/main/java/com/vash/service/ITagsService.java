package com.vash.service;

import java.util.List;

import com.vash.domaine.TagsVo;
import com.vash.entities.Tags;

public interface ITagsService {

	Tags save(TagsVo tagsVo);
	List<TagsVo> findAll();
}
