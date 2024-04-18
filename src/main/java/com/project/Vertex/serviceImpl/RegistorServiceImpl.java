package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import com.project.Vertex.service.RegisterService;

@Service
public class RegistorServiceImpl implements RegisterService{

	@Autowired
    private RegisterRepository registerRepository;

    @Override
    public Register saveRegistration(Register register) {
        return registerRepository.save(register);
    }
    
   
    
   
    public String checkEmailAndSendNotification(String email) {
        Register register = registerRepository.findByEmail(email);
        if (register == null) {
        	System.out.println("Not Found");
            return "Email not found in database";
        } else {
          //  sendEmailCheckNotification(email);
            System.out.println("founded");
            return "Email found in database. Notification sent.";
        }
    }
    
   

    @Autowired
    private PasswordEncoder passwordEncoder; 
    
    @Override
    public String updatePassword(String email, String newPassword) {
        Register register = registerRepository.findByEmail(email);
        if (register == null) {
            return "Email not found in database";
        } else {
            // Update password with bcrypt encoding
            String encodedPassword = passwordEncoder.encode(newPassword);
            register.setPassword(encodedPassword);
            registerRepository.save(register);
            return "Password updated successfully";
        }
    }
}
