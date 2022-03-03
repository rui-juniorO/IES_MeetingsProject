package com.meeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_meeting")
public class Contact_Meeting {
	
	private long userId;
	private long meetingId;
	private long id;
	
	
	@Column(name = "userId", nullable = false)
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Column(name = "meetingId", nullable = false)
	public long getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(long meetingId) {
		this.meetingId = meetingId;
	}
	
	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	 
	 
}
