package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.Auction;
import com.project.Vertex.repository.AuctionRepository;
import com.project.Vertex.service.AuctionService;

@Service
public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	AuctionRepository auctionRepository;

	@Override
	public Auction saveAuction(Auction auction) {
		
		return auctionRepository.save(auction);
	}

	@Override
	public List<Auction> getAll() {
		
		return auctionRepository.findAll();
	}

}
