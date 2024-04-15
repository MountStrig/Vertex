package com.project.Vertex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.BankDetails;
import com.project.Vertex.entity.PropertyDetails;
import com.project.Vertex.service.AuctionServices;

@Controller
public class CombinedController {
	
	@Autowired
	AuctionServices auctionServices;

    @GetMapping("/AuctionForm")
    public String showAuctionForm(Model model) {
        // Create empty objects to bind with the form
        AuctionEntity auctionEntity = new AuctionEntity();
        PropertyDetails propertyDetails = new PropertyDetails();
        BankDetails bankDetails = new BankDetails();

        model.addAttribute("entity", auctionEntity); 
        model.addAttribute("propertyDetails", propertyDetails);
        model.addAttribute("bankDetails", bankDetails);

        return "AuctionForm"; 
    }
   
    @PostMapping("/saveAuctionForm")
    public String saveAuctionForm(@ModelAttribute("entity") AuctionEntity auctionEntity,
                                  @ModelAttribute("propertyDetails") PropertyDetails propertyDetails,
                                  @ModelAttribute("bankDetails") BankDetails bankDetails) {
        // Call service to save auction details
        auctionServices.saveAuctionDetails(auctionEntity, propertyDetails, bankDetails);

        // Redirect to a success page or another appropriate endpoint
        return "redirect:/AuctionForm";
    }
    
    @GetMapping("/allAuctionDetails")
    public String showAllAuctionDetails(Model model) {
        // Retrieve all details using the service method
        List<Object[]> allDetails = auctionServices.getAllDetails();

        // Add the retrieved list to the model to be accessed in the view
        model.addAttribute("allDetails", allDetails);

        return "PropertyAuctionDetail";
    }
}
