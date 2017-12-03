package com.cesar.blog.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.cesar.blog.entity.Tag;

public interface TagsRepository extends CrudRepository<Tag, Long> {

	List<Tag> findAll();
	
	Set<Tag> findById(Long id);
	
}
