package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.Register;

public interface RegisterService {
	
	Register saveRegistration(Register register);

	String checkEmailAndSendNotification(String email);
}
