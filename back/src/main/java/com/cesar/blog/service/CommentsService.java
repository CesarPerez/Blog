package com.cesar.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import com.cesar.blog.entity.Comment;

public interface CommentsService {

	public List<Comment> getAll();
	
	@Transactional
	public void save(Comment comment);
	
}
