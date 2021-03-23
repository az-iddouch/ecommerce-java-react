package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Review;

public class ReviewConverter {

	public static Review toBo(ReviewVo reviewVo) {
		Review review = null;
		if (!ObjectUtils.isEmpty(reviewVo)) {
			review = new Review();
			review.setId(reviewVo.getId());
			review.setComment(reviewVo.getComment());
			review.setNote(reviewVo.getNote());
			review.setProperty(PropertyConvert.toBo(reviewVo.getProperty()));
			review.setUser(UserConverter.toBo(reviewVo.getUser()));
		}

		return review;
	}

	public static ReviewVo toVo(Review review) {
		ReviewVo reviewVo = null;
		if (!ObjectUtils.isEmpty(review)) {
			reviewVo = new ReviewVo();
			reviewVo.setId(review.getId());
			reviewVo.setComment(review.getComment());
			reviewVo.setNote(review.getNote());
			reviewVo.setProperty(PropertyConvert.toVo(review.getProperty()));
			reviewVo.setUser(UserConverter.toVo(review.getUser()));
		}

		return reviewVo;
	}
	
	
	public static List<ReviewVo> toListVo(List<Review> Reviews) {
		List<ReviewVo> reviewVos = new ArrayList<ReviewVo>();
		if (!ObjectUtils.isEmpty(Reviews)) {
			for (Review Review : Reviews) {
				reviewVos.add(toVo(Review));
			}
			
		}

		return reviewVos;
	}
	
	
	public static List<Review> toListBo(List<ReviewVo> ReviewVos) {
		List<Review> reviews = new ArrayList<Review>();
		if (!ObjectUtils.isEmpty(ReviewVos)) {
			for (ReviewVo ReviewVo : ReviewVos) {
				reviews.add(toBo(ReviewVo));
			}
			
		}

		return reviews;
	}
}
