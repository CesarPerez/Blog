package com.cesar.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesar.blog.entity.Tag;
import com.cesar.blog.service.TagsService;

@RestController
@RequestMapping("/api/tags")
public class TagsController {

	@Autowired
	public TagsService TagsService;
	
	@GetMapping(value="/all", produces = "application/json")
	public ResponseEntity getAllPublications(){
		List<Tag> tags =  TagsService.getAll();
		return new ResponseEntity(tags, HttpStatus.OK);
	}
	
	@PostMapping(value="", produces = "application/json")
	public ResponseEntity addPublication(@RequestBody Tag tag){
		TagsService.save(tag);
		return ResponseEntity.ok(null);
	}
	
}
