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

import com.project.Vertex.entity.Interest;
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

	/*
	 * @GetMapping("/") public String getIndexPage(Model model) {
	 * model.addAttribute("register", new Register()); List<AuctionEntity>
	 * allDetails = auctionServices.getAllDetails();
	 * 
	 * // Decode Base64 images for each AuctionEntity for (AuctionEntity auction :
	 * allDetails) { PropertyDetails propertyDetails = auction.getPropertyDetails();
	 * if (propertyDetails != null && propertyDetails.getImages() != null) {
	 * List<byte[]> decodedImages = decodeBase64Images(propertyDetails.getImages());
	 * propertyDetails.setDecodedImages(decodedImages); // Set decoded images } }
	 * 
	 * // Add the retrieved list to the model to be accessed in the view
	 * model.addAttribute("imintrest", new Interest());
	 * model.addAttribute("allDetails", allDetails);
	 * 
	 * // Check authentication status boolean isAuthenticatedFromDb = false;
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); if (authentication !=
	 * null && authentication.isAuthenticated()) { Object principal =
	 * authentication.getPrincipal(); if (principal instanceof UserDetails) {
	 * UserDetails userDetails = (UserDetails) principal; if
	 * (userDetails.getUsername() != null) { isAuthenticatedFromDb = true; } } }
	 * model.addAttribute("isAuthenticatedFromDb", isAuthenticatedFromDb);
	 * 
	 * return "index"; }
	 * 
	 * 
	 * private List<byte[]> decodeBase64Images(List<byte[]> list) { List<byte[]>
	 * decodedImages = new ArrayList<>(); Base64.Decoder decoder =
	 * Base64.getDecoder(); for (byte[] base64Image : list) { try { byte[]
	 * decodedImage = decoder.decode(base64Image); decodedImages.add(decodedImage);
	 * } catch (IllegalArgumentException e) {
	 * System.err.println("Failed to decode Base64 image: " + e.getMessage()); } }
	 * return decodedImages; }
	 * 
	 * 
	 * private List<byte[]> decodeBase64Images(List<byte[]> list) { List<byte[]>
	 * decodedImages = new ArrayList<>(); Base64.Decoder decoder =
	 * Base64.getDecoder(); for (byte[] base64Image : list) { try { byte[]
	 * decodedImage = decoder.decode(base64Image); decodedImages.add(decodedImage);
	 * } catch (IllegalArgumentException e) {
	 * System.err.println("Failed to decode Base64 image: " + e.getMessage()); //
	 * Handle the exception gracefully, e.g., skip the problematic image // You can
	 * also log the problematic image for further investigation } } return
	 * decodedImages; }
	 */
	
	
	/*
	 * @GetMapping("/") public String getIndexPage(Model model) {
	 * model.addAttribute("register", new Register()); List<AuctionEntity>
	 * allDetails = auctionServices.getAllDetails();
	 * 
	 * // Decode Base64 images for each AuctionEntity for (AuctionEntity auction :
	 * allDetails) { PropertyDetails propertyDetails = auction.getPropertyDetails();
	 * if (propertyDetails != null && propertyDetails.getImages() != null) {
	 * List<byte[]> decodedImages = decodeBase64Images(propertyDetails.getImages());
	 * propertyDetails.setImages(decodedImages); // Set decoded images to be
	 * displayed } }
	 * 
	 * // Add the retrieved list to the model to be accessed in the view
	 * model.addAttribute("imintrest", new Interest());
	 * model.addAttribute("allDetails", allDetails);
	 * 
	 * // Check authentication status boolean isAuthenticatedFromDb = false;
	 * Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); if (authentication !=
	 * null && authentication.isAuthenticated()) { Object principal =
	 * authentication.getPrincipal(); if (principal instanceof UserDetails) {
	 * UserDetails userDetails = (UserDetails) principal; if
	 * (userDetails.getUsername() != null) { isAuthenticatedFromDb = true; } } }
	 * model.addAttribute("isAuthenticatedFromDb", isAuthenticatedFromDb);
	 * 
	 * return "index"; }
	 * 
	 * private List<byte[]> decodeBase64Images(List<byte[]> list) { List<byte[]>
	 * decodedImages = new ArrayList<>(); Base64.Decoder decoder =
	 * Base64.getDecoder(); for (int i = 0; i < list.size(); i++) { byte[]
	 * base64Image = list.get(i); try { byte[] decodedImage =
	 * decoder.decode(base64Image); decodedImages.add(decodedImage); } catch
	 * (IllegalArgumentException e) { // Log the error and provide information about
	 * the problematic image
	 * System.err.println("Failed to decode Base64 image at index " + i + ": " +
	 * e.getMessage()); } } return decodedImages; }
	 * 
	 */
	
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
	    model.addAttribute("register", new Register());
	    List<AuctionEntity> allDetails = auctionServices.getAllDetails();

	    System.out.println(allDetails);
	    // Encode Base64 images for each AuctionEntity
	    for (AuctionEntity auction : allDetails) {
	        PropertyDetails propertyDetails = auction.getPropertyDetails();
	        if (propertyDetails != null && propertyDetails.getImages() != null) {
	            List<String> encodedImages = encodeBase64Images(propertyDetails.getImages());
	            propertyDetails.setEncodedImages(encodedImages); // Set encoded images to be displayed
	        }
	    }

	    // Add the retrieved list to the model to be accessed in the view
	    model.addAttribute("imintrest", new Interest());
	    model.addAttribute("allDetails", allDetails);

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

	private List<String> encodeBase64Images(List<byte[]> list) {
	    List<String> encodedImages = new ArrayList<>();
	    Base64.Encoder encoder = Base64.getEncoder();
	    for (int i = 0; i < list.size(); i++) {
	        byte[] base64Image = list.get(i);
	        try {
	            String encodedImage = encoder.encodeToString(base64Image);
	            encodedImages.add(encodedImage);
	            System.out.println("Image Encoded " + i + " Success");
	        } catch (IllegalArgumentException e) {
	            // Log the error and provide information about the problematic image
	            System.err.println("Failed to encode Base64 image at index " + i + ": " + e.getMessage());
	        }
	    }
	    return encodedImages;
	}

    
    
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
	public String saveAuctionRequest(@ModelAttribute("request") Model model) {

		// model.addAttribute("request", new AuctionRequest());
		// auctionRequestService.saveAuctionRequest(auctionRequest);

		return "redirect:/userSuccess";
	}

}
