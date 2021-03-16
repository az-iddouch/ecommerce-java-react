package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Image;

public interface IImageRepository extends JpaRepository<Image, Long>{

}
