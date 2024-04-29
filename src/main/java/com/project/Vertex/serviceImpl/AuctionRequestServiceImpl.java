package com.project.Vertex.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.AuctionRequest;
import com.project.Vertex.repository.AuctionRequestRepository;
import com.project.Vertex.service.AuctionRequestService;;

@Service
public class AuctionRequestServiceImpl implements AuctionRequestService{
	
	@Autowired
	AuctionRequestRepository auctionRequestRepository;
	@Override
	public AuctionRequest saveAuctionRequest(AuctionRequest auctionRequest) {
		
		return auctionRequestRepository.save(auctionRequest);
	}
	
}
