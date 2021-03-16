package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.Tags;

public interface ITagsRepository extends JpaRepository<Tags, Long>{

}
