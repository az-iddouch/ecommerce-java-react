package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Tags;

public class TagsConverter {

	
	public static Tags toBo(TagsVo tagsVo) {
		Tags tag=null;
		if(!ObjectUtils.isEmpty(tagsVo)) {
			tag=new Tags();
			tag.setId(tagsVo.getId());
			tag.setNameTag(tagsVo.getNameTag());
			tag.setImage(ImageConverter.toBo(tagsVo.getImage()));
			tag.setPropertys(PropertyConvert.toListBo(tagsVo.getPropertys()));
		}
		return tag;
	}
	
	public static TagsVo toVo(Tags tags) {
		TagsVo tagVo=null;
		if(!ObjectUtils.isEmpty(tags)) {
			tagVo=new TagsVo();
			tagVo.setId(tags.getId());
			tagVo.setNameTag(tags.getNameTag());
			tagVo.setImage(ImageConverter.toVo(tags.getImage()));
			tagVo.setPropertys(PropertyConvert.toListVo(tags.getPropertys()));
		}
		return tagVo;
	}
	
	
	public static List<TagsVo> toListVo(List<Tags> tags) {
		List<TagsVo> tagVos=new ArrayList<TagsVo>();
		if(!ObjectUtils.isEmpty(tags)) {
			for (Tags tag : tags) {
				tagVos.add(toVo(tag));
			}
		}
		return tagVos;
	}
	
	
	public static List<Tags> toListBo(List<TagsVo> tagsVo) {
		List<Tags> tags=new ArrayList<Tags>();
		if(!ObjectUtils.isEmpty(tagsVo)) {
			for (TagsVo tagVo : tagsVo) {
				tags.add(toBo(tagVo));
			}
		}
		return tags;
	}
	
}
