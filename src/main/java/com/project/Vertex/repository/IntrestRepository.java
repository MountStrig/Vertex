package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.Intrest;

@Repository
public interface IntrestRepository extends JpaRepository<Intrest, Long>{

}
