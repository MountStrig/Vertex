package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.Intrest;
import com.project.Vertex.entity.Register;
import com.project.Vertex.service.CallBackService;
import com.project.Vertex.service.IntrestService;

@Controller
public class IntrestController {
	
	@Autowired
	private CallBackService callBackService;
	
	@Autowired
	private IntrestService intrestService;
	
	
	public String saveCallback(Register register, AuctionEntity auctionEntity, Model model) {
		
		callBackService.saveCallBack(register, auctionEntity);

        // Add attributes to the model if needed
        model.addAttribute("message", "Callback saved successfully!");
        
		return "";
	}
	
	@PostMapping("/intrest")
	public String saveIntrest(@ModelAttribute("imintrest") Intrest intrest, Model model) {
		System.out.println("Hii ");
		intrestService.saveIntrest(intrest);
		model.addAttribute("msg", "Intrest Saved....!");
		return "redirect:/";
	}
}
