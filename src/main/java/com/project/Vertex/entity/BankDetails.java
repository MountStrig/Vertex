package com.project.Vertex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankDetails {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String bankName;
	    private Double emd;
	    private String branchName;
	    private String serviceProvider;
	    private Double reservePrice;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public Double getEmd() {
			return emd;
		}
		public void setEmd(Double emd) {
			this.emd = emd;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getServiceProvider() {
			return serviceProvider;
		}
		public void setServiceProvider(String serviceProvider) {
			this.serviceProvider = serviceProvider;
		}
		public Double getReservePrice() {
			return reservePrice;
		}
		public void setReservePrice(Double reservePrice) {
			this.reservePrice = reservePrice;
		}
		
		public BankDetails(Long id, String bankName, Double emd, String branchName, String serviceProvider,
				Double reservePrice) {
			super();
			this.id = id;
			this.bankName = bankName;
			this.emd = emd;
			this.branchName = branchName;
			this.serviceProvider = serviceProvider;
			this.reservePrice = reservePrice;
		}
		
		@Override
		public String toString() {
			return "BankDetails [id=" + id + ", bankName=" + bankName + ", emd=" + emd + ", branchName=" + branchName
					+ ", serviceProvider=" + serviceProvider + ", reservePrice=" + reservePrice + "]";
		}
		public BankDetails() {
			
		}
	    
	    
}
