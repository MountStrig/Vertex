package com.project.Vertex.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.Vertex.entity.AuctionRequest;
import com.project.Vertex.repository.AuctionRepository;
import com.project.Vertex.service.AuctionRequestService;
import com.project.Vertex.service.AuctionService;

public class AuctionRequestServiceImpl implements AuctionRequestService{
	
	@Autowired
	AuctionRequestService auctionRequestService;

	@Override
	public AuctionRequest saveAuctionRequest(AuctionRequest auctionRequest) {
		
		return auctionRequestService.saveAuctionRequest(auctionRequest);
	}
	
}
