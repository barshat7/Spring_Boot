package com.techstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techstack.entity.Reader;
import com.techstack.repository.ReaderRepository;

@Controller
//@RequestMapping("/")
public class HomeController {

	@Autowired
	private ReaderRepository readerRepository;
	
	@GetMapping({"/","/login"})
	public String login() {
		
		return "login";
	}
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	@PostMapping("/register")
	public String register(Reader reader) {
		System.out.println("Register user: " +reader.getFullname());
		System.out.println("username: " +reader.getUsername());
		readerRepository.save(reader);
		String username = reader.getUsername();
		return "redirect:/login";
	}
}
