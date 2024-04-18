package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import com.project.Vertex.service.RegisterService;

@Controller
public class ForgotControler {
	
	@Autowired
	 RegisterService registerService;
	
		@GetMapping("/forgetPassword")
	    public String showForgetPasswordForm() {
	        return "emailLink";
	    }
	
	
		
		@PostMapping("/emailLinks")
		public String checkEmailAndSendNotification(@RequestParam("email") String email, Model model) {
		    System.out.println("Received email: " + email);
		    
		    String result = registerService.checkEmailAndSendNotification(email);
		    
		    if (result.equals("Email not found in database")) {
		        model.addAttribute("error", "Bad Request, Please Enter Valid Email Id");
		        return "emailLink"; 
		    } else {
		    	
		        model.addAttribute("email", email);
		        sendPasswordResetEmail(email);
		        return "redirect:/"; 
		    }
		}

	    
			@PostMapping("/forgetPasswordSet")
		    public String updatePassword(@RequestParam("email") String email,
		                                 @RequestParam("newPassword") String newPassword,
		                                 @RequestParam("confirmPassword") String confirmPassword,
		                                 Model model) {
		        if (!newPassword.equals(confirmPassword)) {
		            model.addAttribute("error", "Passwords do not match.");
		            return "redirect:/forgetPassword";
		        }
		        
		        String passwordReset = registerService.updatePassword(email, newPassword);
		        if (passwordReset.equals("Password updated successfully")) {
		            return "/";
		        } else {
		            model.addAttribute("error", passwordReset);
		            return "redirect:/forgetPassword";
		        }
		    }
			
			 @Autowired
			 private JavaMailSender javaMailSender;
			 
			 public void sendPasswordResetEmail(String email) {
		         
				 String resetUrl = "http://localhost:8080/forgot?email=" + email;

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
			 
				@GetMapping("/forgot")
				public String showForget(@RequestParam("email") String email, Model model) {
				    model.addAttribute("email", email);
				    return "forgot";
				}
}
