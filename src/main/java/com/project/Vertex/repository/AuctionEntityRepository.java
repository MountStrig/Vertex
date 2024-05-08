package com.project.Vertex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.AuctionEntity;

@Repository
public interface AuctionEntityRepository extends JpaRepository<AuctionEntity, Long> {
    
	 @Query("SELECT a, p, b FROM AuctionEntity a JOIN a.propertyDetails p JOIN a.bankDetails b")
	 List<Object[]> findAllDetails();
	
	 List<AuctionEntity> findByAuctionIdAndPropertyDetailsAssetCategoryAndPropertyDetailsProvinceAndPropertyDetailsCityAndBankDetailsBankName(
		        long auctionId, String category, String state, String city, String bank);
}
