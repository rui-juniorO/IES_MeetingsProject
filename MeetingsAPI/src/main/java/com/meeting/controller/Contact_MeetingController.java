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
import com.meeting.model.Contact_Meeting;
import com.meeting.model.User;
import com.meeting.services.Contact_MeetingService;
import com.meeting.services.UserService;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", })
@RestController

public class Contact_MeetingController {
	
	@Autowired 
	private Contact_MeetingService service;
	
	@GetMapping("/api/contact_meeting")
	public List<Contact_Meeting> getAllContact_Meeting() {
		return service.getContact_Meeting();
	}
	
	@GetMapping("/api/contact_meeting/{id}")
	public ResponseEntity<Contact_Meeting> getContact_Meeting(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		return service.getContact_MeetingById(id);
	}
	
	@PostMapping("/api/contact_Meeting")
	public Contact_Meeting addContact_Meeting(@Valid @RequestBody Contact_Meeting contact_meeting) {
		return service.createContact_Meeting(contact_meeting);
	}
	
}
