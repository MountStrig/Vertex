package com.project.Vertex.service;

import java.util.List;

import com.project.Vertex.entity.Register;

public interface RegisterService {
	
		Register saveRegistration(Register register);
	    String checkEmailAndSendNotification(String email);
	    String updatePassword(String email, String newPassword);
		Register findByEmail(String loggedInUsername);
	    
//		void savePasswordResetToken(String email, String token);
//		boolean isValidPasswordResetToken(String token);
//		String getEmailByToken(String token);
}
