package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long>{

}
