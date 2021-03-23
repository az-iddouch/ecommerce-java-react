package com.vash.service;

import java.util.List;

import com.vash.domaine.ReviewVo;
import com.vash.entities.Review;

public interface IReviewService {

	Review save(ReviewVo reviewVo);

	List<ReviewVo> findAll();
}
