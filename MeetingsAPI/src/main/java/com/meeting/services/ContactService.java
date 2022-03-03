package com.meeting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meeting.exception.ResourceNotFoundException;
import com.meeting.model.Contact;
import com.meeting.repository.ContactRepository;


@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}
	
	public ResponseEntity<Contact> getContactById(long Id) throws ResourceNotFoundException{
		Contact contacts = contactRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Contact not found  id=" + Id));
		return ResponseEntity.ok().body(contacts);
	}
	
	public ResponseEntity<Contact> getContactByuserId(long Id) throws ResourceNotFoundException{
		Contact contacts = contactRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Contacts not found  id=" + Id));
		return ResponseEntity.ok().body(contacts);
	}
	
	public Contact createContact(Contact contact) {
		
		return contactRepository.save(contact);
		
	}
	
}
