package com.cesar.blog.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cesar.blog.entity.Comment;
import com.cesar.blog.entity.Entry;
import com.cesar.blog.entity.Tag;
import com.cesar.blog.service.EntriesService;
import com.cesar.blog.utils.DateUtil;
import com.cesar.blog.repository.CommentsRepository;
import com.cesar.blog.repository.EntriesRepository;
import com.cesar.blog.repository.TagsRepository;

@Service
public class EntriesServiceImpl 
implements EntriesService{

	@Autowired
	private EntriesRepository entriesRepository;
	
	@Autowired
	private TagsRepository tagsRepository;
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Value("#{new java.util.Date()}")
	private Date date;
	
	@Override
	public List<Entry> getAll() {
		return entriesRepository.findAllByOrderByCreationDateDesc();
	}

	@Override
	public void save(Entry entry) {
		entry.setCreationDate(date);
		entriesRepository.save(entry);
	}

	@Override
	public void assignTag(Long entryId, Long tagId) {
		Entry entry = entriesRepository.findById(entryId);
		Set<Tag> tag = tagsRepository.findById(tagId);
		entry.setTags(tag);
		entriesRepository.save(entry);
	}

	@Override
	public void assignComment(Long entryId, Long commentId) {
		Entry entry = entriesRepository.findById(entryId);
		List<Comment> comment = commentsRepository.findById(commentId);
		entry.setComments(comment);
		entriesRepository.save(entry);
	}

	
	
}
