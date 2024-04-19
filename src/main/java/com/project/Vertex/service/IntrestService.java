package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.Intrest;

public interface IntrestService {
	
	Intrest saveIntrest(Intrest intrest);
	
	List<Intrest> getAllIntrests();
}
