package com.developer.angularjs_oracle.model;

import java.io.Serializable;

public class UserModel extends DomainResponseModel implements Serializable{

	private int id;
	private String fullName;
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
