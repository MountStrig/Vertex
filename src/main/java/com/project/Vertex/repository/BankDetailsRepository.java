package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.BankDetails;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long>{

}
