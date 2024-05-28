package com.project.Vertex.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class PropertyDetails {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		private String borrowerName;
	    private String assetCategory;
	    private String city;
	    private String province;
	    private String area;
	    @DateTimeFormat(pattern = "HH:mm")
	    private LocalTime auctionStartTime;
	    private LocalDate auctionStartDate;
	    private LocalDate applicationSubmissionDate;
	    
	  
	    @Lob
		@Column(length = Integer.MAX_VALUE)
		@ElementCollection
		private List<byte[]> images;
		private List<String> encodedImages;
		 
		 public List<String> getEncodedImages() {
		        return encodedImages;
		    }

		    public void setEncodedImages(List<String> encodedImages) {
		        this.encodedImages = encodedImages;
		    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getBorrowerName() {
			return borrowerName;
		}

		public void setBorrowerName(String borrowerName) {
			this.borrowerName = borrowerName;
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

		public LocalTime getAuctionStartTime() {
			return auctionStartTime;
		}

		public void setAuctionStartTime(LocalTime auctionStartTime) {
			this.auctionStartTime = auctionStartTime;
		}

		public LocalDate getAuctionStartDate() {
			return auctionStartDate;
		}

		public void setAuctionStartDate(LocalDate auctionStartDate) {
			this.auctionStartDate = auctionStartDate;
		}

		public LocalDate getApplicationSubmissionDate() {
			return applicationSubmissionDate;
		}

		public void setApplicationSubmissionDate(LocalDate applicationSubmissionDate) {
			this.applicationSubmissionDate = applicationSubmissionDate;
		}

		public List<byte[]> getImages() {
			return images;
		}

		public void setImages(List<byte[]> images) {
			this.images = images;
		}

		public PropertyDetails() {
		}

		public PropertyDetails(Long id, String borrowerName, String assetCategory, String city, String province, String area,
				LocalTime auctionStartTime, LocalDate auctionStartDate, LocalDate applicationSubmissionDate,
				List<byte[]> images) {
			this.id = id;
			this.borrowerName = borrowerName;
			this.assetCategory = assetCategory;
			this.city = city;
			this.province = province;
			this.area = area;
			this.auctionStartTime = auctionStartTime;
			this.auctionStartDate = auctionStartDate;
			this.applicationSubmissionDate = applicationSubmissionDate;
			this.images = images;
		}

		@Override
		public String toString() {
			return "PropertyDetails [id=" + id + ", borrowerName=" + borrowerName + ", assetCategory=" + assetCategory
					+ ", city=" + city + ", province=" + province + ", area=" + area + ", auctionStartTime=" + auctionStartTime
					+ ", auctionStartDate=" + auctionStartDate + ", applicationSubmissionDate=" + applicationSubmissionDate
					+ ", images=" + images + "]";
		}
	

		
		
		public void setDecodedImages(List<byte[]> decodedImages) {
		    this.images = decodedImages;
		}

		public List<byte[]> getDecodedImages() {
		    return images;
		}

	
}