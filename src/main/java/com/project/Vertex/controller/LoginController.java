package com.project.Vertex.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Base64;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.service.AuctionServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Intrest;
import com.project.Vertex.entity.PropertyDetails;
import com.project.Vertex.entity.Register;
import com.project.Vertex.service.AuctionRequestService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class LoginController {
	
	
	@Autowired
	AuctionServices auctionServices;
	
	/*
	 * @GetMapping("/") public String getIndexPage(Model model) {
	 * model.addAttribute("register", new Register()); List<AuctionEntity>
	 * allDetails = auctionServices.getAllDetails();
	 * 
	 * // Add the retrieved list to the model to be accessed in the view
	 * model.addAttribute("imintrest", new Intrest());
	 * model.addAttribute("allDetails", allDetails); boolean isAuthenticatedFromDb =
	 * false;
	 * 
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); if (authentication !=
	 * null && authentication.isAuthenticated()) { Object principal =
	 * authentication.getPrincipal(); if (principal instanceof UserDetails) { //
	 * Check if the UserDetails are loaded from your database UserDetails
	 * userDetails = (UserDetails) principal; System.out.println(userDetails); //
	 * Example: Check if the UserDetails has a specific role or attribute if
	 * (userDetails.getUsername() != null) { // This condition can be customized
	 * based on your UserDetails implementation isAuthenticatedFromDb = true;
	 * System.out.println("Set to true"); } } }
	 * System.out.println(isAuthenticatedFromDb);
	 * 
	 * // Add a model attribute to indicate specific authentication status
	 * model.addAttribute("isAuthenticatedFromDb", isAuthenticatedFromDb); return
	 * "index"; }
	 */
	
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
	    model.addAttribute("register", new Register());
	    List<AuctionEntity> allDetails = auctionServices.getAllDetails();

	    // Decode Base64 images for each AuctionEntity
	    for (AuctionEntity auction : allDetails) {
	        PropertyDetails propertyDetails = auction.getPropertyDetails();
	        if (propertyDetails != null && propertyDetails.getBase64Images() != null) {
	            List<byte[]> decodedImages = decodeBase64Images(propertyDetails.getBase64Images());
	            propertyDetails.setDecodedImages(decodedImages); // Set decoded images
	            System.out.println("Auction ID: " + auction.getId());
	            System.out.println("Base64 Images: " + propertyDetails.getBase64Images().size());
	            System.out.println("First Base64 Image: " + propertyDetails.getBase64Images().get(0));
	          
	        }
	    }

	    // Add the retrieved list to the model to be accessed in the view
	    model.addAttribute("imintrest", new Intrest());
	    model.addAttribute("allDetails", allDetails);
	    System.out.println(allDetails.toString());
	    // Check authentication status
	    boolean isAuthenticatedFromDb = false;
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null && authentication.isAuthenticated()) {
	        Object principal = authentication.getPrincipal();
	        if (principal instanceof UserDetails) {
	            UserDetails userDetails = (UserDetails) principal;
	            if (userDetails.getUsername() != null) {
	                isAuthenticatedFromDb = true;
	            }
	        }
	    }
	    model.addAttribute("isAuthenticatedFromDb", isAuthenticatedFromDb);

	    return "index";
	}

	private List<byte[]> decodeBase64Images(List<byte[]> list) {
	    List<byte[]> decodedImages = new ArrayList<>();
	    for (byte[] base64Image : list) {
	        byte[] decodedImage = Base64.getDecoder().decode(base64Image);
	        decodedImages.add(decodedImage);
	    }
	    return decodedImages;
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
	       // model.addAttribute("request", new AuctionRequest());
	        
	        return "redirect:/callbackdeatilsbyuser";
	}	
	
	@Autowired
	AuctionRequestService auctionRequestService;
	
	@PostMapping("/saveAuctionRequest")
	public String saveAuctionRequest(@ModelAttribute("request")  Model model) {
		   
		//   model.addAttribute("request", new AuctionRequest());
		 //  auctionRequestService.saveAuctionRequest(auctionRequest);
		   
		   return "redirect:/userSuccess";
	   }
	
	
}
