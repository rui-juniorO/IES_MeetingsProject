package com.meeting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meeting.exception.ResourceNotFoundException;
import com.meeting.model.Meeting;
import com.meeting.repository.MeetingRepository;

@Service
public class MeetingService {
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	public List<Meeting> getMeetings(){
		return meetingRepository.findAll();
	}
	
	public ResponseEntity<Meeting> getMeetingById(long Id) throws ResourceNotFoundException{
		Meeting meetins = meetingRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Meet not found  id=" + Id));
		return ResponseEntity.ok().body(meetins);
	}
	
	public ResponseEntity<Meeting> getContactByuserId(long Id) throws ResourceNotFoundException{
		Meeting meetings = meetingRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Meet not found  id=" + Id));
		return ResponseEntity.ok().body(meetings);
	}
	
	public Meeting createMeeting(Meeting meetings) {
		
		return meetingRepository.save(meetings);
		
	}
}
