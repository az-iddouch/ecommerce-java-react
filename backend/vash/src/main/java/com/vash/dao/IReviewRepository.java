package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Review;

public interface IReviewRepository extends JpaRepository<Review, Long>{

}
