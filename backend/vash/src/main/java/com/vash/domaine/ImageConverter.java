package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Image;

public class ImageConverter {

	public static Image toBo(ImageVo imageVo) {
		Image image = null;

		if (!ObjectUtils.isEmpty(imageVo)) {
			image = new Image();
			image.setId(imageVo.getId());
			image.setUrl(imageVo.getUrl());
			//image.setProperty(PropertyConvert.toBo(imageVo.getProperty()));
			//image.setUser(UserConverter.toBo(imageVo.getUser()));
			//image.setTag(TagsConverter.toBo(imageVo.getTag()));
		}

		return image;
	}

	public static ImageVo toVo(Image image) {
		ImageVo imageVo = null;

		if (!ObjectUtils.isEmpty(image)) {
			imageVo = new ImageVo();
			imageVo.setId(image.getId());
			imageVo.setUrl(image.getUrl());
//			imageVo.setProperty(PropertyConvert.toVo(image.getProperty()));
//			imageVo.setUser(UserConverter.toVo(image.getUser()));
//			imageVo.setTag(TagsConverter.toVo(image.getTag()));
		}

		return imageVo;
	}

	public static List<ImageVo> toListVo(List<Image> imageBos) {
		List<ImageVo> imageVos = new ArrayList<ImageVo>();

		if (!ObjectUtils.isEmpty(imageBos)) {
			for (Image image : imageBos) {
				imageVos.add(toVo(image));
			}

		}

		return imageVos;
	}

	public static List<Image> toListBo(List<ImageVo> imageVos) {
		List<Image> images = new ArrayList<Image>();

		if (!ObjectUtils.isEmpty(imageVos)) {
			for (ImageVo imageVo : imageVos) {
				images.add(toBo(imageVo));
			}
		}

		return images;
	}

}
