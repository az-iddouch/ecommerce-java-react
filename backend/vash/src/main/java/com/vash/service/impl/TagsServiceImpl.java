package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.ITagsRepository;
import com.vash.domaine.TagsConverter;
import com.vash.domaine.TagsVo;
import com.vash.entities.Tags;
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

	@Override
	public TagsVo findById(Long id) {
		Optional<Tags> tagsOptional=iTagsRepository.findById(id);
		TagsVo tagsVo=new TagsVo();
		if(tagsOptional.isPresent()) {
			tagsVo=TagsConverter.toVo(tagsOptional.get());
		}
		return tagsVo;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean checked=true;
		iTagsRepository.deleteById(id);
		TagsVo tagsVo= findById(id);
		if(!ObjectUtils.isEmpty(tagsVo)) {
			checked=true;
		}
		return checked;
	}

	@Override
	public List<TagsVo> findAllByIds(List<Long> ids) {

		return TagsConverter.toListVo(iTagsRepository.findAllById(ids));
	}
	
}
