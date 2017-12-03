package com.cesar.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import com.cesar.blog.entity.Tag;

public interface TagsService {

	public List<Tag> getAll();
	
	@Transactional
    public void save(Tag tag);
	
}
