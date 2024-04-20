package com.project.Vertex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Intrest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long auctionId;
	private String name;
	private String mobileNumber;
	
	public Intrest() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Intrest(Long id, Long auctionId, String name, String mobileNumber) {
		super();
		this.id = id;
		this.auctionId = auctionId;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Intrest [id=" + id + ", auctionId=" + auctionId + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ "]";
	}
	
	
	
}
