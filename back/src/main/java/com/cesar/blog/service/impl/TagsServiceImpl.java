package com.cesar.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cesar.blog.entity.Entry;
import com.cesar.blog.entity.Tag;
import com.cesar.blog.repository.TagsRepository;
import com.cesar.blog.service.TagsService;

@Service
public class TagsServiceImpl implements TagsService{

	@Autowired
	public TagsRepository tagsRepository;
	
	@Value("#{new java.util.Date()}")
	private Date date;
	
	@Override
	public List<Tag> getAll() {
		return tagsRepository.findAll();
	}

	@Override
	public void save(Tag tag) {
		tag.setCreationDate(date);
		tagsRepository.save(tag);
	}
	
	
}
