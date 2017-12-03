package com.cesar.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesar.blog.entity.Entry;
import com.cesar.blog.service.EntriesService;

@RestController
@RequestMapping("/api/entries")
public class EntriesController {

	@Autowired
	public EntriesService entriesService;
	
	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity getAllPublications(){
		List<Entry> publications =  entriesService.getAll();
		return new ResponseEntity(publications, HttpStatus.OK);
	}
	
	@PostMapping(value = "", consumes="application/json", produces = "application/json")
	public ResponseEntity addPublication(@RequestBody Entry entry){
		entriesService.save(entry);
		return ResponseEntity.ok(true);
	}
	
	@PutMapping(value = "{entryId}/tags/{tagId}", produces = "application/json")
	public ResponseEntity assignTag(@PathVariable Long entryId, @PathVariable Long tagId){
		entriesService.assignTag(entryId, tagId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping(value = "{entryId}/comments/{commentId}", produces = "application/json")
	public ResponseEntity assignComment(@PathVariable Long entryId, @PathVariable Long commentId){
		entriesService.assignComment(entryId, commentId);
		return ResponseEntity.ok(null);
	}
	
}
