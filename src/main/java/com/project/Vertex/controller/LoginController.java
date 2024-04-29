package com.project.Vertex.controller;

import java.time.LocalDate;
import java.util.List;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.service.AuctionServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.AuctionRequest;
import com.project.Vertex.entity.Intrest;
import com.project.Vertex.entity.Register;
import com.project.Vertex.service.AuctionRequestService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class LoginController {
	
	
	@Autowired
	AuctionServices auctionServices;
	
	 @GetMapping("/")
	    public String getIndexPage(Model model) {
	        model.addAttribute("register", new Register());
		 List<AuctionEntity> allDetails = auctionServices.getAllDetails();

		 // Add the retrieved list to the model to be accessed in the view
		 model.addAttribute("imintrest", new Intrest());
		 model.addAttribute("allDetails", allDetails);
		 boolean isAuthenticatedFromDb = false;

		    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    if (authentication != null && authentication.isAuthenticated()) {
		        Object principal = authentication.getPrincipal();
		        if (principal instanceof UserDetails) {
		            // Check if the UserDetails are loaded from your database
		            UserDetails userDetails = (UserDetails) principal;
		            System.out.println(userDetails);
		            // Example: Check if the UserDetails has a specific role or attribute
		            if (userDetails.getUsername() != null) {
		                // This condition can be customized based on your UserDetails implementation
		                isAuthenticatedFromDb = true;
		                System.out.println("Set to true");
		            }
		        }
		    }
		    System.out.println(isAuthenticatedFromDb);

		    // Add a model attribute to indicate specific authentication status
		    model.addAttribute("isAuthenticatedFromDb", isAuthenticatedFromDb);
	        return "index";
	    }
		/*
		 * @GetMapping("/login") public String getLoginPage(Model model) {
		 * 
		 * return "login"; }
		 */
	 
	 
	 @GetMapping("/adminSuccess")
		public String showAdminPage(Model model) {
			
			return "main";
		}
	
	@GetMapping("/userSuccess")
	public String getIndexPage1(Model model) {
	model.addAttribute("register", new Register());
	        
	        // Add a new instance of AuctionRequest to the model for the form
	        model.addAttribute("request", new AuctionRequest());
	        
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
