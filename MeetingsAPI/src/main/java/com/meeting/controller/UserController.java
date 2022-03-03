package com.meeting.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.exception.ResourceNotFoundException;
import com.meeting.model.User;
import com.meeting.services.UserService;



@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", })
@RestController
public class UserController {
	
	@Autowired 
	private UserService service;
	
	@GetMapping("/api/users")
	public List<User> getAllUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		return service.getUserById(id);
	}
	
	@PostMapping("/api/users")
	public User addUser(@Valid @RequestBody User user) {
		return service.createUser(user);
	}

	@PostMapping("/api/users/login")
	public Map<String, String> loginUser(@Valid @RequestBody User user) {
		return service.loginUser(user);
	}
	
}
