package com.cesar.blog.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.cesar.blog.entity.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long> {

	List<Comment> findAll();
	
	List<Comment> findById(Long id);
	
}
