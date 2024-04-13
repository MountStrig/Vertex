package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.AuctionEntity;

@Repository
public interface AuctionEntityRepository extends JpaRepository<AuctionEntity, Long> {
    
}
