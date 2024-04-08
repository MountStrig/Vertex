package com.project.Vertex.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.Vertex.entity.Auction;
import com.project.Vertex.entity.Register;
import com.project.Vertex.service.AuctionService;
import com.project.Vertex.service.PropertyService;

@Controller
public class LoginController {
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	AuctionService auctionService;
	
	 @GetMapping("/")
	    public String getIndexPage(Model model) {
	        model.addAttribute("register", new Register()); 
	        return "index";
	    }
	
	@GetMapping("/userSuccess")
	public String getIndexPage1(Model model) {
	//model.addAttribute("register", new Register());
		
		 List<Auction> auctions = auctionService.getAll();
		 auctions.forEach(auction -> auction.setSubmissionDate(LocalDate.now()));
	        System.out.println("Number of auctions retrieved: " + auctions.size());
	        model.addAttribute("auctions", auctions);
	        
	        return "index1";
	}	
	
	
}
