package com.project.Vertex.service;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.BankDetails;
import com.project.Vertex.entity.PropertyDetails;

public interface AuctionServices {
	
	void saveAuctionDetails(AuctionEntity auctionEntity, PropertyDetails propertyDetails, BankDetails bankDetails);
}
