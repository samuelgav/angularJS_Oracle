package com.developer.angularjs_oracle.dto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="user_detail")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional=false)
	@NotNull
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_userdetail")
	@SequenceGenerator(name="seq_userdetail",sequenceName="incremento_id_user_detail",allocationSize=1)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(unique=true)
	private String username;
	private String password;
	@Column(unique=true)
	private String email;
	@Column(name="contact_number")
	private String contactNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
