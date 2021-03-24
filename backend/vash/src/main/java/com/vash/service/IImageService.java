package com.vash.service;

import java.util.List;

import com.vash.domaine.ImageVo;

public interface IImageService {

	ImageVo save(ImageVo imageVo);
	List<ImageVo> findAll();

}
