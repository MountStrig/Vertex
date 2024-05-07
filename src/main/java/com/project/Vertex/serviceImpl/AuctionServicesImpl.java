package com.project.Vertex.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.BankDetails;
import com.project.Vertex.entity.PropertyDetails;
import com.project.Vertex.repository.AuctionEntityRepository;
import com.project.Vertex.repository.BankDetailsRepository;
import com.project.Vertex.repository.PropertyDetailsRepository;
import com.project.Vertex.service.AuctionServices;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuctionServicesImpl implements AuctionServices{
	
	@Autowired
	private  AuctionEntityRepository auctionEntityRepository;
	@Autowired
    private  PropertyDetailsRepository propertyDetailsRepository;
	@Autowired
    private  BankDetailsRepository bankDetailsRepository;
    
   

    @Override
    @Transactional
    public void saveAuctionDetails(AuctionEntity auctionEntity, PropertyDetails propertyDetails, BankDetails bankDetails) {
        // Set PropertyDetails and BankDetails in AuctionEntity
        auctionEntity.setPropertyDetails(propertyDetails);
        auctionEntity.setBankDetails(bankDetails);

        // Save PropertyDetails and BankDetails first to generate IDs (if not assigned)
        propertyDetailsRepository.save(propertyDetails);
        bankDetailsRepository.save(bankDetails);

        // Save AuctionEntity (with associated PropertyDetails and BankDetails)
        auctionEntityRepository.save(auctionEntity);

    }
    
    @Override
    public List<AuctionEntity> getAllDetails() {
        return auctionEntityRepository.findAll();
    }

    public AuctionEntity findById(Long auctionId) {
        // Use AuctionEntityRepository to find AuctionEntity by ID
        Optional<AuctionEntity> optionalAuctionEntity = auctionEntityRepository.findById(auctionId);

        // Check if AuctionEntity was found
        if (optionalAuctionEntity.isPresent()) {
            return optionalAuctionEntity.get(); // Return the found AuctionEntity
        } else {
            return null; // Return null if AuctionEntity with given ID is not found
        }
    }
}
