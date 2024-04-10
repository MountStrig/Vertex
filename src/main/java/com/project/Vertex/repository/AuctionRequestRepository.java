package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.AuctionRequest;

@Repository
public interface AuctionRequestRepository extends JpaRepository<AuctionRequest, Long>{

}
