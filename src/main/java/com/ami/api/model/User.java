package com.ami.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "first_name")
	private String fName;
	@Column(name = "last_name")
	private String lName;
	private String gender;
	private LocalDate dob;
	private String email;
	
	@OneToMany(
			fetch = FetchType.EAGER,
			orphanRemoval = true,
			cascade = CascadeType.ALL,
			mappedBy = "user"
	)
	@JsonIgnoreProperties(value = "user")
	List<Address> addresses = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(String fName, String lName, String gender, LocalDate dob, String email) {
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}


	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
