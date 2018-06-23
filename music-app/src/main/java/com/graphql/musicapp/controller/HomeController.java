package com.graphql.musicapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.musicapp.model.Album;
import com.graphql.musicapp.repository.AlbumRepository;

@RestController
@RequestMapping("/admin")
public class HomeController {

	@Autowired
	private AlbumRepository albumRepository;
	
	private void init(){
		
		
		
		
		Album a1 = new Album("a1","And Justice For All","Metal","Metallica","1998",new String[]{"One","Harvester of Sorrow"});
		Album a2 = new Album("a2","Blackbird","Rock","Alter Bridge","2007",new String[]{"Watch over you","Before tomorrow comes"});
		//List<Album> albums = new ArrayList<>();
		albumRepository.save(a1);
		albumRepository.save(a2);
	}
	
	@GetMapping("/init")
	public ResponseEntity<String> initAlbum(){
		
		this.init();
		return new ResponseEntity<String>("Created",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Album> getAll(){
		
		return albumRepository.findAll();
	}
	
}
