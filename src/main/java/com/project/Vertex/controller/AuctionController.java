package com.project.Vertex.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.repository.AuctionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.service.AuctionRequestService;

@Controller
public class AuctionController {

	@Autowired
	AuctionEntityRepository RepoAuction;
	

		@GetMapping("/Auctiondetails/{id}")
		public String AuctiondetailsPage(@PathVariable Long id, Principal principal, Model model) {
			Optional<AuctionEntity> auction = RepoAuction.findById(id);
			 boolean isAuthenticatedFromDb = false;

			    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			    if (authentication != null && authentication.isAuthenticated()) {
			        Object principal1 = authentication.getPrincipal();
			        if (principal1 instanceof UserDetails) {
			            // Check if the UserDetails are loaded from your database
			            UserDetails userDetails = (UserDetails) principal1;
			            System.out.println(userDetails);
			            // Example: Check if the UserDetails has a specific role or attribute
			            if (userDetails.getUsername() != null) {
			                // This condition can be customized based on your UserDetails implementation
			                isAuthenticatedFromDb = true;
			                System.out.println(userDetails);
			                System.out.println("Set to true");
			            }
			        }
			    }
			    System.out.println(isAuthenticatedFromDb);

			    // Add a model attribute to indicate specific authentication status
			    model.addAttribute("isAuthenticatedFromDb", isAuthenticatedFromDb);
			model.addAttribute("auction", auction);
		  return "PropertyAuctionDetail";
		}
	    
		
//	@GetMapping("/Interestedetails")
//	public String ShowInterestedbackdetails() {
//		return "IamInterested";
//	}
	       
}
