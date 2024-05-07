package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.Interest;

public interface InterestService {
	
	Interest saveInterest(Interest intrest);
	
	List<Interest> getAllInterests();

}
