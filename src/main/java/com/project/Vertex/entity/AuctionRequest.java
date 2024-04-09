package com.project.Vertex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuctionRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private long mobileNumber;
	private String state;
	private String pLocation1;
	private String pLocation2;
	private String pLocation3;
	private long pincode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getpLocation1() {
		return pLocation1;
	}
	public void setpLocation1(String pLocation1) {
		this.pLocation1 = pLocation1;
	}
	public String getpLocation2() {
		return pLocation2;
	}
	public void setpLocation2(String pLocation2) {
		this.pLocation2 = pLocation2;
	}
	public String getpLocation3() {
		return pLocation3;
	}
	public void setpLocation3(String pLocation3) {
		this.pLocation3 = pLocation3;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public AuctionRequest(long id, String name, String email, long mobileNumber, String state, String pLocation1,
			String pLocation2, String pLocation3, long pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.state = state;
		this.pLocation1 = pLocation1;
		this.pLocation2 = pLocation2;
		this.pLocation3 = pLocation3;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "AuctionRequest [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", state=" + state + ", pLocation1=" + pLocation1 + ", pLocation2=" + pLocation2 + ", pLocation3="
				+ pLocation3 + ", pincode=" + pincode + "]";
	}
	
	public AuctionRequest() {
		
	}
}
