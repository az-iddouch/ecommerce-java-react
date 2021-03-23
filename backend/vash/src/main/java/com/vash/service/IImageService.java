package com.vash.service;

import java.util.List;

import com.vash.domaine.ImageVo;
import com.vash.entities.Image;

public interface IImageService {

	Image save(ImageVo imageVo);
	List<ImageVo> findAll();

}
