package com.cesar.blog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cesar.blog.entity.Entry;

public interface EntriesRepository extends CrudRepository<Entry, Long> {

	List<Entry> findAllByOrderByCreationDateDesc();
	
	Entry findById(Long id);
	
}
