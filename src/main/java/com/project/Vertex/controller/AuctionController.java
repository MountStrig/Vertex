package com.project.Vertex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Auction;
import com.project.Vertex.entity.AuctionRequest;
import com.project.Vertex.service.AuctionRequestService;
import com.project.Vertex.service.AuctionService;

@Controller
public class AuctionController {
	
	@Autowired
	AuctionService auctionService;
	
	  @GetMapping("/create")
	    public String showCreateAuctionPage() {
	       
	        return "create";
	    }

		@GetMapping("/Auctiondetails")
		public String AuctiondetailsPage() {
		  return "PropertyAuctionDetail";
		}
	    
	    @PostMapping("/addAccount")
	    public String saveAuction(@ModelAttribute("auction") Auction auction, Model model) {
	    	 model.addAttribute("auction", new Auction());
	    	auctionService.saveAuction(auction);
	        return "redirect:/create"; 
	    }
	    
	       
}
