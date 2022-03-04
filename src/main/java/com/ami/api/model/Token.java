package com.ami.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String auth;
	@Column(name = "email", unique = true)
	private String email;
	private String origin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() 
		+ " Auth: " + this.getAuth()
		+ " Email: " + this.getEmail()
		+ " Origin: " + this.getOrigin();
	}
	

}
