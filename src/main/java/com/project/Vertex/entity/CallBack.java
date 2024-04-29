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
public class CallBack {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "auction_entity_id")
	    private AuctionEntity auctionEntity;

	    @ManyToOne
	    @JoinColumn(name = "register_id")
	    private Register register;

		public CallBack() {
			
		}

		@Override
		public String toString() {
			return "CallBack [id=" + id + ", auctionEntity=" + auctionEntity + ", register=" + register + "]";
		}

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

		public CallBack(Long id, AuctionEntity auctionEntity, Register register) {
			super();
			this.id = id;
			this.auctionEntity = auctionEntity;
			this.register = register;
		}
		
		
}
