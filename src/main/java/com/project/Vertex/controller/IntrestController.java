package com.project.Vertex.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.CallBack;
import com.project.Vertex.entity.CallbackDetailsDTO;
import com.project.Vertex.entity.Intrest;
import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.CallBackRepository;
import com.project.Vertex.service.AuctionServices;
import com.project.Vertex.service.CallBackService;
import com.project.Vertex.service.IntrestService;
import com.project.Vertex.service.RegisterService;

@Controller
public class IntrestController {
	
	
	
	@Autowired
	private IntrestService intrestService;
	
	
	/*
	 * public String saveCallback(Register register, AuctionEntity auctionEntity,
	 * Model model) {
	 * 
	 * callBackService.saveCallBack(register, auctionEntity);
	 * 
	 * // Add attributes to the model if needed model.addAttribute("message",
	 * "Callback saved successfully!");
	 * 
	 * return ""; }
	 */
	
	@PostMapping("/intrest")
	public String saveIntrest(@ModelAttribute("imintrest") Intrest intrest, Model model) {
		System.out.println("Hii ");
		intrestService.saveIntrest(intrest);
		model.addAttribute("msg", "Intrest Saved....!");
		return "redirect:/";
	}
	
		@GetMapping("/Interestedetails")
	    public String getAllIntrests(Model model) {
	      
	        List<Intrest> intrestList = intrestService.getAllIntrests();
	        model.addAttribute("intrestList", intrestList);
	       
	        return "IamInterested"; 
	    }
	
		
		
		@Autowired
		RegisterService registerService;
		
		@Autowired
		private CallBackService callbackService;
	
		/*
		 * @PostMapping("/callback/request") public String
		 * requestCallback(@RequestParam("auctionId") Long auctionId, Principal
		 * principal, Model model) {
		 * 
		 * System.out.println("HII here there you go"); System.out.println(auctionId);
		 * String loggedInUsername = principal.getName(); // Get logged-in user's
		 * username
		 * 
		 * System.out.println(loggedInUsername);
		 * 
		 * // Fetch user details (Register entity) based on username (email or username)
		 * Register user = registerService.findByEmail(loggedInUsername);
		 * 
		 * if (user != null) { // Create a new Callback entity AuctionEntity
		 * auctionEntity = new AuctionEntity(); auctionEntity.setId(auctionId); //
		 * Assuming you have an existing AuctionEntity with the given ID
		 * 
		 * CallBack callback = new CallBack(auctionId, auctionEntity, user);
		 * callback.setAuctionEntity(auctionEntity); callback.setRegister(user);
		 * 
		 * // Save the callback using the service
		 * callbackService.saveCallback(callback);
		 * 
		 * // Optionally, add a success message to the model
		 * model.addAttribute("message", "Callback requested successfully!"); } else {
		 * // Handle case where user is not found model.addAttribute("error",
		 * "User not found!"); }
		 * 
		 * // Redirect to a success page or back to the details page return
		 * "redirect:/"; // Redirect to the home page or another appropriate URL }
		 */
		
		/*
		 * @PostMapping("/callback/request") public String
		 * requestCallback(@RequestParam("auctionId") Long auctionId, Model model) { //
		 * Retrieve authentication object from SecurityContextHolder Authentication
		 * authentication = SecurityContextHolder.getContext().getAuthentication();
		 * 
		 * if (authentication != null && authentication.isAuthenticated()) { // Get
		 * logged-in user's username (typically email or username) String
		 * loggedInUsername = authentication.getName();
		 * 
		 * // Fetch user details (Register entity) based on username Register user =
		 * registerService.findByEmail(loggedInUsername);
		 * 
		 * if (user != null) { // Print user details (for demonstration purposes)
		 * System.out.println("Logged-in User Details:");
		 * System.out.println("Username: " + user.getEmail()); // Assuming email is the
		 * identifier System.out.println("Name: " + user.getName()); // Example: Fetch
		 * full name System.out.println("Role(s): " + user.getRole()); // Example: Fetch
		 * user roles System.out.println(user.getId());
		 * 
		 * // Proceed with creating and saving the callback entity AuctionEntity
		 * auctionEntity = new AuctionEntity(); auctionEntity.setId(auctionId); //
		 * Assuming you have an existing AuctionEntity with the given ID
		 * 
		 * CallBack callback = new CallBack(auctionId, auctionEntity, user);
		 * callback.setAuctionEntity(auctionEntity); callback.setRegister(user);
		 * 
		 * // Save the callback using the service
		 * callbackService.saveCallback(callback);
		 * 
		 * // Optionally, add a success message to the model
		 * model.addAttribute("message", "Callback requested successfully!"); } else {
		 * // Handle case where user is not found model.addAttribute("error",
		 * "User not found!"); } } else { // Handle case where no user is authenticated
		 * model.addAttribute("error", "User not authenticated!"); }
		 * 
		 * // Redirect to a success page or back to the details page return
		 * "redirect:/"; // Redirect to the home page or another appropriate URL }
		 */
		
		@Autowired
		private AuctionServices auctionService;
		
		@Autowired
		CallBackRepository callBackRepository;
		
		@PostMapping("/callback/request")
		public String requestCallback(@RequestParam("auctionId") Long auctionId, Model model) {
		    // Retrieve authentication object from SecurityContextHolder
		    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		    if (authentication != null && authentication.isAuthenticated()) {
		        // Get logged-in user's username (typically email or username)
		        String loggedInUsername = authentication.getName();

		        // Fetch user details (Register entity) based on username
		        Register user = registerService.findByEmail(loggedInUsername);

		        if (user != null) {
		            // Fetch AuctionEntity by ID
		            AuctionEntity auctionEntity = auctionService.findById(auctionId);

		            if (auctionEntity != null) {
		                // Create a new callback entity and set the auctionEntity and register
		                CallBack callback = new CallBack();
		                callback.setAuctionEntity(auctionEntity);
		                callback.setRegister(user);
		                	
		                // Save the callback using the service
		                callBackRepository.save(callback);

		                // Optionally, add a success message to the model
		                model.addAttribute("message", "Callback requested successfully!");
		            } else {
		                // Handle case where auction is not found
		                model.addAttribute("error", "Auction not found!");
		            }
		        } else {
		            // Handle case where user is not found
		            model.addAttribute("error", "User not found!");
		        }
		    } else {
		        // Handle case where no user is authenticated
		        model.addAttribute("error", "User not authenticated!");
		    }

		    // Redirect to a success page or back to the details page
		    return "redirect:/"; // Redirect to the home page or another appropriate URL
		}

  
		
		
		/*
		 * @GetMapping("/callbackdeatils") public String ShowCallbackdetails() { return
		 * "Callbacktable"; }
		 */
		
		@Autowired
		CallBackService callBackService;
			
		@GetMapping("/callbackdeatils")
		public String showCallbacks(Model model) {
		    List<CallBack> callbacks = callBackService.getAllCallbacks();
		    List<CallbackDetailsDTO> callbackDetailsList = new ArrayList<>();

		    for (CallBack callback : callbacks) {
		        AuctionEntity auctionEntity = callback.getAuctionEntity();
		        Register register = callback.getRegister();

		        // Create CallbackDetailsDTO object
		        CallbackDetailsDTO callbackDetailsDTO = new CallbackDetailsDTO(callback, auctionEntity, register);

		        // Add CallbackDetailsDTO to the list
		        callbackDetailsList.add(callbackDetailsDTO);
		    }

		    // Add callbackDetailsList to the model with a single attribute name
		    model.addAttribute("callbacksData", callbackDetailsList);

		    return "Callbacktable"; // HTML template name (Callbacktable.html)
		}
		
		
		@GetMapping("/callbackdeatilsbyuser")
	    public String showCallbacksByLoginUser(Model model, Principal principal) {
	        // Retrieve the email of the logged-in user
	        String loggedInUsername = principal.getName();

	        // Find the user (Register entity) based on the email
	        Register user = registerService.findByEmail(loggedInUsername);

	        if (user != null) {
	            // Get all callbacks associated with the logged-in user
	            List<CallBack> callbacks = callBackService.findCallbacksByUser(user);

	            // Create a list to hold callback details DTOs
	            List<CallbackDetailsDTO> callbackDetailsList = new ArrayList<>();

	            // Populate callback details DTOs with associated entities
	            for (CallBack callback : callbacks) {
	                AuctionEntity auctionEntity = callback.getAuctionEntity();

	                // Create CallbackDetailsDTO object
	                CallbackDetailsDTO callbackDetailsDTO = new CallbackDetailsDTO(callback, auctionEntity, user);

	                // Add CallbackDetailsDTO to the list
	                callbackDetailsList.add(callbackDetailsDTO);
	            }

	            // Add callbackDetailsList to the model with a single attribute name
	            model.addAttribute("callbacksData", callbackDetailsList);

	            return "index1"; // HTML template name (Callbacktable.html)
	        } else {
	            // Handle case where user is not found
	            model.addAttribute("error", "User not found!");
	            return "error-page"; // Provide appropriate error handling page
	        }
	    }




}
