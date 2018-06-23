package com.graphql.musicapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.musicapp.service.AlbumGQlService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/api")
public class AlbumController {
	
	@Autowired
	private AlbumGQlService albumService;

	@PostMapping
	public ResponseEntity<Object> getGraphQlBook(@RequestBody String query){
		
		ExecutionResult result = albumService.getGraphQL().execute(query);
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
}
