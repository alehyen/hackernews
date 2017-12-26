package com.hackernews.user;


import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class User {

	@Id
	protected String id;
	protected String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	protected String password;
	
	public User() {
		
	}
	
	public User(String id,String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
	public User(User user) {
		this.id = user.id;
		this.email = user.email;
		this.password = user.password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
