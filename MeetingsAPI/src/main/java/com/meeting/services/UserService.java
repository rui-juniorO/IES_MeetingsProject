package com.meeting.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meeting.exception.ResourceNotFoundException;
import com.meeting.model.User;

import com.meeting.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public ResponseEntity<User> getUserById(long Id) throws ResourceNotFoundException{
		User users = userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("User not found  id=" + Id));
		return ResponseEntity.ok().body(users);
	}
	
	public User createUser(User user) {
		User userDb=userRepository.findByEmail(user.getEmail());
		
		if (userDb == null) {
			return userRepository.save(user);
			
		}
		return user;
	}
	
	public Map<String, String> loginUser(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		
		User userDb = userRepository.findByEmail(email);
		if(userDb == null) {
			Map<String, String> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Email not found");
			return response;
		}
		
		if(!password.equals(userDb.getPassword())) {
			Map<String, String> response = new HashMap<>();
			response.put("status", "error");
			response.put("message", "Wrong password");
			return response;
		}
		
		Map<String, String> response = new HashMap<>();
		response.put("status", "sucess");
		response.put("message", "Login");
		response.put("name", userDb.getName());
		response.put("email", userDb.getEmail());
		response.put("id", String.valueOf(userDb.getId()));
		
		return response;
	}
	
	
	
}
