package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.Auction;

public interface AuctionService {
	
	Auction saveAuction(Auction auction);
	List<Auction> getAll();
}
