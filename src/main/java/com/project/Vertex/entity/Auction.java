package com.project.Vertex.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Auction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bank;
	private long auctionNumber;
	private String assetOnAuction;
	private String city;
	private LocalDate submissionDate = LocalDate.now();
	private double price;
	private long emd;
	private String eventType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public long getAuctionNumber() {
		return auctionNumber;
	}

	public void setAuctionNumber(long auctionNumber) {
		this.auctionNumber = auctionNumber;
	}

	public String getAssetOnAuction() {
		return assetOnAuction;
	}

	public void setAssetOnAuction(String assetOnAuction) {
		this.assetOnAuction = assetOnAuction;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getEmd() {
		return emd;
	}

	public void setEmd(long emd) {
		this.emd = emd;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Auction(Long id, String bank, long auctionNumber, String assetOnAuction, String city,
			LocalDate submissionDate, double price, long emd, String eventType) {
		super();
		this.id = id;
		this.bank = bank;
		this.auctionNumber = auctionNumber;
		this.assetOnAuction = assetOnAuction;
		this.city = city;
		this.submissionDate = submissionDate;
		this.price = price;
		this.emd = emd;
		this.eventType = eventType;
	}
	
	@Override
	public String toString() {
		return "Auction [id=" + id + ", bank=" + bank + ", auctionNumber=" + auctionNumber + ", assetOnAuction="
				+ assetOnAuction + ", city=" + city + ", submissionDate=" + submissionDate + ", price=" + price
				+ ", emd=" + emd + ", eventType=" + eventType + "]";
	}

	public Auction() {
		
	}
}
