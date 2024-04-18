package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Register;
import com.project.Vertex.service.RegisterService;

import jakarta.mail.internet.MimeMessage;

@Controller
public class RegisterController {
		
		@Autowired
	    private RegisterService registerService;

		@Autowired
		private PasswordEncoder PasswordEncode;
		
		
		    @PostMapping("/saveRegister")
		    public String handleRegistration(@ModelAttribute("register") Register register, Model model) {
		       
		        if (register != null) {
				 	String a =	PasswordEncode.encode(register.getPassword());
					register.setPassword(a);
		            registerService.saveRegistration(register);
		            model.addAttribute("message", "Registration successful");
		            sendRegistrationEmail(register.getEmail(), register);

		            return "index";
		        }
		        
		        return "index";
		    }
		    
		    @Autowired
		    private JavaMailSender javaMailSender;

		    public void sendRegistrationEmail(String toEmail, Register register) {
		        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

		        String subject = "Welcome to VERTEX PROSERVE";
		        String emailContent = "Dear " + register.getName() + ",\n\n"
		                + "Thank you for registering with VERTEX PROSERVE. Here are your registration details:\n\n"
		                + "Name: " + register.getName() + "\n"
		                + "Email: " + register.getEmail() + "\n"
		                + "Mobile Number: " + register.getMobileNumber() + "\n"
		                + "State: " + register.getState() + "\n"
		                + "City: " + register.getCity() + "\n"
		                + "Pincode: " + register.getPincode() + "\n"
		                + "Address: " + register.getAddress() + "\n\n"
		                + "Regards,\nYour VERTEX PROSERVE Team";

		        try {
		            helper.setTo(toEmail);
		            helper.setSubject(subject);
		            helper.setText(emailContent);

		            javaMailSender.send(mimeMessage);
		        } catch (Exception e) {
		            e.printStackTrace(); // Handle email sending exception
		        }
		    }
		    
		    
    
}
