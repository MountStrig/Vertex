package com.project.Vertex.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Interest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "auction_details_id")
	private AuctionEntity auctionId;
	private String name;
	private String mobileNumber;
	
	public Interest() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuctionEntity getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(AuctionEntity auctionId) {
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

	public Interest(Long id, AuctionEntity auctionId, String name, String mobileNumber) {
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
