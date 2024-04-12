package com.project.Vertex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private Long mobileNumber;
	private String email;
	private String password;
	private String state;
	private String city;
	private Long pincode;
	private String address;
	private String role = "user";
	
	public Register() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Register(Long id, String name, Long mobileNumber, String email, String password, String state, String city,
			Long pincode, String address, String role) {
		super();
		Id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.state = state;
		this.city = city=null;
		this.pincode = pincode;
		this.address = address;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Register [Id=" + Id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", password=" + password + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", address=" + address + ", role=" + role + "]";
	}

	
}