package com.project.Vertex.controller;

import java.util.List;
import java.util.Optional;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.repository.AuctionEntityRepository;
import com.project.Vertex.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Auction;
import com.project.Vertex.entity.AuctionRequest;
import com.project.Vertex.service.AuctionRequestService;
import com.project.Vertex.service.AuctionService;

@Controller
public class AuctionController {

	@Autowired
	AuctionEntityRepository RepoAuction;
	@Autowired
	AuctionService auctionService;

		@GetMapping("/Auctiondetails/{id}")
		public String AuctiondetailsPage(@PathVariable Long id, Model model) {
			Optional<AuctionEntity> auction = RepoAuction.findById(id);
			model.addAttribute("auction", auction);
		  return "PropertyAuctionDetail";
		}
	    
	    @PostMapping("/addAccount")
	    public String saveAuction(@ModelAttribute("auction") Auction auction, Model model) {
	    	 model.addAttribute("auction", new Auction());
	    	auctionService.saveAuction(auction);
	        return "redirect:/create"; 
	    }

		@GetMapping("/callbackdeatils")
		public String ShowCallbackdetails() {
			return "Callbacktable";
		}
	@GetMapping("/Interestedetails")
	public String ShowInterestedbackdetails() {
		return "IamInterested";
	}
	       
}
