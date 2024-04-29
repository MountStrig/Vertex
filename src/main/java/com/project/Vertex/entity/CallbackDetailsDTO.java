package com.project.Vertex.entity;

public class CallbackDetailsDTO {
	
		private CallBack callback;
	    private AuctionEntity auctionEntity;
	    private Register register;

	    // Constructor
	    public CallbackDetailsDTO(CallBack callback, AuctionEntity auctionEntity, Register register) {
	        this.callback = callback;
	        this.auctionEntity = auctionEntity;
	        this.register = register;
	    }

	    // Getters and setters
	    public CallBack getCallback() {
	        return callback;
	    }

	    public void setCallback(CallBack callback) {
	        this.callback = callback;
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

}
