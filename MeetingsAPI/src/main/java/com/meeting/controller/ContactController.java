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
import com.meeting.model.Contact;
import com.meeting.services.ContactService;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", })
@RestController
public class ContactController {

	@Autowired 
	private ContactService service;
	
	@GetMapping("/api/contacts")
	public List<Contact> getAllContacts() {
		return service.getContacts();
	}
	
	@GetMapping("/api/contact/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		return service.getContactById(id);
	}
	
	@GetMapping("/api/contact/user/{id}")
	public ResponseEntity<Contact> getContactByUser(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
		return service.getContactByuserId(id);
	}
	
	@PostMapping("/api/contact")
	public Contact addContact(@Valid @RequestBody Contact contact) {
		return service.createContact(contact);
	}	
	
}
