package com.cesar.blog.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cesar.blog.entity.Comment;
import com.cesar.blog.repository.CommentsRepository;
import com.cesar.blog.repository.EntriesRepository;
import com.cesar.blog.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;
	
	@Value("#{new java.util.Date()}")
	private Date date;
	
	@Override
	public List<Comment> getAll() {
		return commentsRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Comment comment) {
		comment.setCreationDate(date);
		commentsRepository.save(comment);
		
	}

	
	
}
