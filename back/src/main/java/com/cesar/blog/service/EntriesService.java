package com.cesar.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import com.cesar.blog.entity.Entry;

public interface EntriesService {

	public List<Entry> getAll();
	
	@Transactional
	public void save(Entry entry);
	
	@Transactional 
	public void assignTag(Long entryId, Long TagId);
	
	@Transactional 
	public void assignComment(Long entryId, Long commentId);
	
}
