package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    
    @Autowired
    private JavaMailSender javaMailSender;
    
   
    public String checkEmailAndSendNotification(String email) {
        Register register = registerRepository.findByEmail(email);
        if (register == null) {
        	System.out.println("Not Found");
            return "Email not found in database";
        } else {
            sendEmailCheckNotification(email);
            System.out.println("founded");
            return "Email found in database. Notification sent.";
        }
    }
    
    public void sendEmailCheckNotification(String email) {
        // Replace "http://yourwebsite.com/reset-password" with your local URL
        String resetUrl = "http://localhost:8080/forget.html?email=" + email;

        String subject = "Password Reset Notification";
        String mainContent = "You can reset your password by clicking the link below:\n\n" + resetUrl;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(mainContent);

        try {
            javaMailSender.send(message);
            System.out.println("Email sent successfully to: " + email);
        } catch (Exception e) {
            System.err.println("Failed to send email to: " + email);
            e.printStackTrace();
        }
    }



}
