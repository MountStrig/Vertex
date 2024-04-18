package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Vertex.service.RegisterService;

@Controller
public class ForgetControler {
	
	@Autowired
	 RegisterService registerService;
	
		@GetMapping("/forgetPassword")
	    public String showForgetPasswordForm() {
	        return "emailLink"; // Assuming this is your form view name
	    }
	
	 
		@PostMapping("/emailLinks")
	    public String checkEmailAndSendNotification(@RequestParam("email") String email, Model model) {
	        System.out.println("Received email: " + email);
	        String result = registerService.checkEmailAndSendNotification(email);
	        model.addAttribute("result", result); 
	        return "redirect:/emailLink";
	    }

	
}
