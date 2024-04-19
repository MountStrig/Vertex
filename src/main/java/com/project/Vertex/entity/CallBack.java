package com.project.Vertex.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CallBack {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "property_details_id")
	    private AuctionEntity auctionEntity;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "Register_id")
		private Register register;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public AuctionEntity getAuctionEntity() {
			return auctionEntity;
		}

		public void setAuctionEntity(AuctionEntity auctionEntity) {
			this.auctionEntity = auctionEntity;
		}

		public Register getRegister() {
			return register;
		}

		public void setRegister(Register register) {
			this.register = register;
		}

		@Override
		public String toString() {
			return "CallBack [id=" + id + ", auctionEntity=" + auctionEntity + ", register=" + register + "]";
		}

		 public CallBack(Long id, AuctionEntity auctionEntity, Register register) {
		        this.id = id;
		        this.auctionEntity = auctionEntity;
		        this.register = register;
		    }

		
		
}
