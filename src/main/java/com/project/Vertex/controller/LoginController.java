package com.project.Vertex.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Auction;
import com.project.Vertex.entity.AuctionRequest;
import com.project.Vertex.entity.Register;
import com.project.Vertex.service.AuctionRequestService;
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
		/*
		 * @GetMapping("/login") public String getLoginPage(Model model) {
		 * 
		 * return "login"; }
		 */
	
	@GetMapping("/userSuccess")
	public String getIndexPage1(Model model) {
	model.addAttribute("register", new Register());
		
		//Retrive All Auction details
		 List<Auction> auctions = auctionService.getAll();
		 auctions.forEach(auction -> auction.setSubmissionDate(LocalDate.now()));
	        System.out.println("Number of auctions retrieved: " + auctions.size());
	       
	        
	        // Add a new instance of AuctionRequest to the model for the form
	        model.addAttribute("request", new AuctionRequest());
	        model.addAttribute("auctions", auctions);
	        
	        return "index1";
	}	
	
	@Autowired
	AuctionRequestService auctionRequestService;
	
	@PostMapping("/saveAuctionRequest")
	public String saveAuctionRequest(@ModelAttribute("request")AuctionRequest auctionRequest, Model model) {
		   
		   model.addAttribute("request", new AuctionRequest());
		   auctionRequestService.saveAuctionRequest(auctionRequest);
		   
		   return "redirect:/userSuccess";
	   }
	
	
}
