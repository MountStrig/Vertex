package com.project.Vertex.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PropertyDetails {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String assetCategory;
	    private String city;
	    private String province;
	    private String area;
	    @DateTimeFormat(pattern = "HH:mm")
	    private LocalDateTime auctionStartTime =null;
	    private LocalDate auctionEndDate;
	    private LocalDate applicationSubmissionDate;
	    private String borrowerName;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssetCategory() {
		return assetCategory;
	}
	public void setAssetCategory(String assetCategory) {
		this.assetCategory = assetCategory;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public LocalDateTime getAuctionStartTime() {
		return auctionStartTime;
	}
	public void setAuctionStartTime(LocalDateTime auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}
	public LocalDate getAuctionEndDate() {
		return auctionEndDate;
	}
	public void setAuctionEndDate(LocalDate auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}
	public LocalDate getApplicationSubmissionDate() {
		return applicationSubmissionDate;
	}
	public void setApplicationSubmissionDate(LocalDate applicationSubmissionDate) {
		this.applicationSubmissionDate = applicationSubmissionDate;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public PropertyDetails(Long id, String assetCategory, String city, String province, String area,
			LocalDateTime auctionStartTime, LocalDate auctionEndDate, LocalDate applicationSubmissionDate,
			String borrowerName) {
		super();
		this.id = id;
		this.assetCategory = assetCategory;
		this.city = city;
		this.province = province;
		this.area = area;
		this.auctionStartTime = auctionStartTime;
		this.auctionEndDate = auctionEndDate;
		this.applicationSubmissionDate = applicationSubmissionDate;
		this.borrowerName = borrowerName;
	}
	@Override
	public String toString() {
		return "PropertyDetails [id=" + id + ", assetCategory=" + assetCategory + ", city=" + city + ", province="
				+ province + ", area=" + area + ", auctionStartTime=" + auctionStartTime + ", auctionEndDate="
				+ auctionEndDate + ", applicationSubmissionDate=" + applicationSubmissionDate + ", borrowerName="
				+ borrowerName + "]";
	}
	public PropertyDetails() {
	
	}
    
    
}
