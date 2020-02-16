package com.kpit.bfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpit.bfs.model.Users;
import com.kpit.bfs.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UsersService service;
	
	@GetMapping("/status/check")
	public String getStatus() {
		return "Working on port "+env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		return new ResponseEntity<>(this.service.createUser(user),HttpStatus.CREATED);
	}

}
