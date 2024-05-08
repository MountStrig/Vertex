package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.BankDetails;
import com.project.Vertex.entity.PropertyDetails;

public interface AuctionServices {
	
	void saveAuctionDetails(AuctionEntity auctionEntity, PropertyDetails propertyDetails, BankDetails bankDetails);
	
	List<AuctionEntity> getAllDetails();

	AuctionEntity findById(Long auctionId);

	List<AuctionEntity> searchProperties(long auctionId, String category, String state, String city, String bank);
	
}
