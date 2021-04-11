package com.vash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.vash.dao.IImageRepository;
import com.vash.domaine.ImageConverter;
import com.vash.domaine.ImageVo;
import com.vash.entities.Image;
import com.vash.security.aop.LogTracer;
import com.vash.service.IImageService;

@Service
@Transactional
public class ImageServiceImpl implements IImageService{
@Autowired
private IImageRepository iImageRepository;

	@Override
	@LogTracer
	public ImageVo save(ImageVo imageVo) {
		return ImageConverter.toVo(iImageRepository.save(ImageConverter.toBo(imageVo)));
	}

	@Override
	@LogTracer
	public List<ImageVo> findAll() {
		return ImageConverter.toListVo(iImageRepository.findAll());
	}

	@Override
	@LogTracer
	public ImageVo findById(Long id) {
		
		Optional<Image> ImageOptional=iImageRepository.findById(id);
		ImageVo imageVo=new ImageVo();
		if(ImageOptional.isPresent()) {
			imageVo=ImageConverter.toVo(ImageOptional.get());
		}
		return imageVo;
	}

	@Override
	@LogTracer
	public boolean deleteById(Long id) {
		boolean checked=true;
		iImageRepository.deleteById(id);
		ImageVo imageVo= findById(id);
		if(!ObjectUtils.isEmpty(imageVo)) {
			checked=true;
		}
		return checked;
	}

}
