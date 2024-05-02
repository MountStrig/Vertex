package com.project.Vertex.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class AuctionEntity {	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	 	@Column(unique = true)
	    private Long auctionId;
	    private String propertyTitle;
	    @Column(length = 3000)
	    private String propertyDescription;
	    private String contactDetails;

	    // One-to-One relationship with PropertyDetails
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "property_details_id")
	    private PropertyDetails propertyDetails;

	    // One-to-One relationship with BankDetails
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "bank_details_id")
	    private BankDetails bankDetails;

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

		public String getPropertyTitle() {
			return propertyTitle;
		}

		public void setPropertyTitle(String propertyTitle) {
			this.propertyTitle = propertyTitle;
		}

		public String getPropertyDescription() {
			return propertyDescription;
		}

		public void setPropertyDescription(String propertyDescription) {
			this.propertyDescription = propertyDescription;
		}

		public String getContactDetails() {
			return contactDetails;
		}

		public void setContactDetails(String contactDetails) {
			this.contactDetails = contactDetails;
		}

		public PropertyDetails getPropertyDetails() {
			return propertyDetails;
		}

		public void setPropertyDetails(PropertyDetails propertyDetails) {
			this.propertyDetails = propertyDetails;
		}

		public BankDetails getBankDetails() {
			return bankDetails;
		}

		public void setBankDetails(BankDetails bankDetails) {
			this.bankDetails = bankDetails;
		}
		
		
		public AuctionEntity(Long id, Long auctionId, String propertyTitle, String propertyDescription,
				String contactDetails, PropertyDetails propertyDetails, BankDetails bankDetails) {
			super();
			this.id = id;
			this.auctionId = auctionId;
			this.propertyTitle = propertyTitle;
			this.propertyDescription = propertyDescription;
			this.contactDetails = contactDetails;
			this.propertyDetails = propertyDetails;
			this.bankDetails = bankDetails;
		}
		
		
		@Override
		public String toString() {
			return "AuctionEntity [id=" + id + ", auctionId=" + auctionId + ", propertyTitle=" + propertyTitle
					+ ", propertyDescription=" + propertyDescription + ", contactDetails=" + contactDetails
					+ ", propertyDetails=" + propertyDetails + ", bankDetails=" + bankDetails + "]";
		}

		public AuctionEntity() {
			
		}
	    
	    
}
