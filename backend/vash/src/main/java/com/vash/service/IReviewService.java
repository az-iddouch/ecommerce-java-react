package com.vash.service;

import java.util.List;

import com.vash.domaine.ReviewVo;

public interface IReviewService {

	ReviewVo save(ReviewVo reviewVo);

	List<ReviewVo> findAll();
}
