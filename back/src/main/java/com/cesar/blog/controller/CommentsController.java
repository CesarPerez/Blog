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

import com.cesar.blog.entity.Comment;
import com.cesar.blog.entity.Entry;
import com.cesar.blog.service.CommentsService;
import com.cesar.blog.service.EntriesService;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
	
	@Autowired
	public CommentsService commentsService;
	
	@GetMapping(value="/all", produces = "application/json")
	public ResponseEntity getAllComments(){
		List<Comment> comments =  commentsService.getAll();
		return new ResponseEntity(comments, HttpStatus.OK);
	}
	
	@PostMapping(value="", produces = "application/json")
	public ResponseEntity addPublication(@RequestBody Comment comment){
		commentsService.save(comment);
		return ResponseEntity.ok(null);
	}
	
}
