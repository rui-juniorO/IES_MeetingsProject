package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meeting.model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	Contact findByUserId(long id);
	
	Contact findByEmail(String email);
}
