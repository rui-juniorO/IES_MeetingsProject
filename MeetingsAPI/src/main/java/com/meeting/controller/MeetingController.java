package com.meeting.controller;

import java.util.List;

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
import com.meeting.model.Meeting;
import com.meeting.services.MeetingService;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", })
@RestController
public class MeetingController {
	@Autowired 
	private MeetingService service;
	
	@GetMapping("/api/meetings")
	public List<Meeting> getAllMeetings() {
		return service.getMeetings();
	}
	
	@GetMapping("/api/meeting/{id}")
	public ResponseEntity<Meeting> getMeeting(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		return service.getMeetingById(id);
	}
	
	@PostMapping("/api/meetings")
	public Meeting addMeeting(@Valid @RequestBody Meeting meeting) {
		return service.createMeeting(meeting);
	}

	
}
