package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.Interest;
import com.project.Vertex.repository.InterestRepository;
import com.project.Vertex.service.InterestService;

@Service
public class IntrestServiceImpl implements InterestService{
	
	@Autowired
	private InterestRepository intrestRepository;
	
	
	@Override
	public Interest saveInterest(Interest intrest) {
		// TODO Auto-generated method stub
		return intrestRepository.save(intrest);
	}

	@Override
	public List<Interest> getAllInterests() {
		// TODO Auto-generated method stub
		return intrestRepository.findAll();
	}

	
}
