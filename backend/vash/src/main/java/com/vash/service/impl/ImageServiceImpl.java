package com.vash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vash.dao.IImageRepository;
import com.vash.domaine.ImageConverter;
import com.vash.domaine.ImageVo;
import com.vash.service.IImageService;

@Service
@Transactional
public class ImageServiceImpl implements IImageService{
@Autowired
private IImageRepository iImageRepository;

	@Override
	public ImageVo save(ImageVo imageVo) {
		return ImageConverter.toVo(iImageRepository.save(ImageConverter.toBo(imageVo)));
	}

	@Override
	public List<ImageVo> findAll() {
		return ImageConverter.toListVo(iImageRepository.findAll());
	}

}
