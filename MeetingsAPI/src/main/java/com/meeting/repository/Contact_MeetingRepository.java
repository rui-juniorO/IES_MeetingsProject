package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.model.Contact_Meeting;


public interface Contact_MeetingRepository extends JpaRepository<Contact_Meeting, Long>{
	
	Contact_Meeting findByUserId(long id);

}
