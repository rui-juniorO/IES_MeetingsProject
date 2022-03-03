package com.meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.model.Meeting;


public interface MeetingRepository extends JpaRepository<Meeting, Long>{
	
}
