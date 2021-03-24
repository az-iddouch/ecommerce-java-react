package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.ITagsRepository;
import com.vash.domaine.TagsConverter;
import com.vash.domaine.TagsVo;
import com.vash.service.ITagsService;

@Service
@Transactional
public class TagsServiceImpl implements ITagsService{
@Autowired
private ITagsRepository iTagsRepository;
	
	@Override
	public TagsVo save(TagsVo tagsVo) {
		return TagsConverter.toVo(iTagsRepository.save(TagsConverter.toBo(tagsVo)));
	}

	@Override
	public List<TagsVo> findAll() {
		return TagsConverter.toListVo(iTagsRepository.findAll());
	}

}
