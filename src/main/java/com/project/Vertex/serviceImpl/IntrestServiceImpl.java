package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.Intrest;
import com.project.Vertex.repository.IntrestRepository;
import com.project.Vertex.service.IntrestService;

@Service
public class IntrestServiceImpl implements IntrestService{
	
	@Autowired
	private IntrestRepository intrestRepository;
	
	
	@Override
	public Intrest saveIntrest(Intrest intrest) {
		// TODO Auto-generated method stub
		return intrestRepository.save(intrest);
	}

	@Override
	public List<Intrest> getAllIntrests() {
		// TODO Auto-generated method stub
		return intrestRepository.findAll();
	}
	
}
