package com.meeting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meeting.exception.ResourceNotFoundException;
import com.meeting.model.Contact_Meeting;
import com.meeting.repository.Contact_MeetingRepository;

@Service
public class Contact_MeetingService {
	
	@Autowired
	private Contact_MeetingRepository contact_MeetingRepository;
	
	public List<Contact_Meeting> getContact_Meeting(){
		return contact_MeetingRepository.findAll();
	}
	
	public ResponseEntity<Contact_Meeting> getContact_MeetingById(long Id) throws ResourceNotFoundException{
		Contact_Meeting contact_meeting = contact_MeetingRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Contact_Meeting not found  id=" + Id));
		return ResponseEntity.ok().body(contact_meeting);
	}
	
	public Contact_Meeting createContact_Meeting(Contact_Meeting contact_meeting) {
		Contact_Meeting contactDb=contact_MeetingRepository.findByUserId(contact_meeting.getUserId());
		
		if (contactDb == null) {
			return contact_MeetingRepository.save(contact_meeting);
			
		}
		return contact_meeting;
	}
	
	
}
