package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.Auction;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long>{

}