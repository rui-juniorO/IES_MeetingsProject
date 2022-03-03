package com.meeting.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	
	private long id;
	private long userId;
	private String name;
	private String email;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Column(name = "userId", nullable = false)
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "name", nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
