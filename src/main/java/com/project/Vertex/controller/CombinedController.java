package com.project.Vertex.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.Vertex.entity.AuctionEntity;
import com.project.Vertex.entity.BankDetails;
import com.project.Vertex.entity.PropertyDetails;
import com.project.Vertex.service.AuctionServices;

import io.jsonwebtoken.io.IOException;

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

	/*
	 * @PostMapping("/saveAuctionForm") public String
	 * saveAuctionForm(@ModelAttribute("entity") AuctionEntity auctionEntity,
	 * 
	 * @ModelAttribute("propertyDetails") PropertyDetails propertyDetails,
	 * 
	 * @ModelAttribute("bankDetails") BankDetails bankDetails) { // Call service to
	 * save auction details auctionServices.saveAuctionDetails(auctionEntity,
	 * propertyDetails, bankDetails); System.out.println(propertyDetails);
	 * 
	 * // Redirect to a success page or another appropriate endpoint return
	 * "redirect:/AuctionForm"; }
	 */
    
	/*
	 * @PostMapping("/saveAuctionForm") public String
	 * saveAuctionForm(@ModelAttribute("entity") AuctionEntity auctionEntity,
	 * 
	 * @ModelAttribute("propertyDetails") PropertyDetails propertyDetails,
	 * 
	 * @ModelAttribute("bankDetails") BankDetails bankDetails,
	 * 
	 * @RequestParam("imageFiles") MultipartFile[] imageFiles) {
	 * 
	 * try { // Convert each uploaded image to byte array and store in
	 * PropertyDetails List<byte[]> imageBytesList = Arrays.stream(imageFiles)
	 * .map(file -> { try { return file.getBytes(); } catch (Exception e) { throw
	 * new RuntimeException("Failed to read image file", e); } })
	 * .collect(Collectors.toList());
	 * 
	 * // Set the list of image byte arrays to PropertyDetails
	 * propertyDetails.setBase64Images(imageBytesList);
	 * 
	 * // Associate PropertyDetails and BankDetails with AuctionEntity
	 * auctionEntity.setPropertyDetails(propertyDetails);
	 * auctionEntity.setBankDetails(bankDetails);
	 * 
	 * // Call service method to save AuctionEntity along with related details
	 * auctionServices.saveAuctionDetails(auctionEntity, propertyDetails,
	 * bankDetails);
	 * 
	 * return "redirect:/AuctionForm"; // Redirect to form page after successful
	 * submission } catch (Exception e) { // Handle exception appropriately (e.g.,
	 * display error message) return "errorPage"; // Redirect to error page } }
	 */
    
    @PostMapping("/saveAuctionForm")
    public String saveAuctionForm(@ModelAttribute("entity") AuctionEntity auctionEntity,
                                  @ModelAttribute("propertyDetails") PropertyDetails propertyDetails,
                                  @ModelAttribute("bankDetails") BankDetails bankDetails,
                                  @RequestParam("imageFiles") MultipartFile[] imageFiles) {

        try {
            // Convert each uploaded image to base64-encoded byte array
            List<byte[]> imageBytesList = Arrays.stream(imageFiles)
                    .map(file -> {
                        try {
                            try {
								return Base64.getEncoder().encode(file.getBytes());
							} catch (java.io.IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        } catch (IOException e) {
                            throw new RuntimeException("Failed to read image file", e);
                        }
						return null;
                    })
                    .collect(Collectors.toList());

            // Set the list of base64-encoded image byte arrays to PropertyDetails
            propertyDetails.setBase64Images(imageBytesList);

            // Associate PropertyDetails and BankDetails with AuctionEntity
            auctionEntity.setPropertyDetails(propertyDetails);
            auctionEntity.setBankDetails(bankDetails);

            // Call service method to save AuctionEntity along with related details
            auctionServices.saveAuctionDetails(auctionEntity, propertyDetails, bankDetails);

            return "redirect:/AuctionForm"; // Redirect to form page after successful submission
        } catch (Exception e) {
            // Handle exception appropriately (e.g., display error message)
            return "errorPage"; // Redirect to error page
        }
    }



	/*
	 * @GetMapping("/allAuctionDetails") public String showAllAuctionDetails(Model
	 * model) { // Retrieve all details using the service method List<AuctionEntity>
	 * allDetails = auctionServices.getAllDetails();
	 * 
	 * // Add the retrieved list to the model to be accessed in the view
	 * model.addAttribute("allDetails", allDetails);
	 * 
	 * return "PropertyAuctionDetail"; }
	 */

  
   
	/*
	 * @PutMapping("/auctionDetails") public String getAllAuctionDetails(Model
	 * model) { // Retrieve all auction details from the service List<AuctionEntity>
	 * allAuctionDetails = auctionServices.getAllDetails();
	 * System.out.println(allAuctionDetails.toString());
	 * System.out.println("Retrieved " + allAuctionDetails.size() +
	 * " auction details.");
	 * 
	 * // Process BLOB images in each AuctionEntity object for (AuctionEntity
	 * auction : allAuctionDetails) { PropertyDetails propertyDetails =
	 * auction.getPropertyDetails(); if (propertyDetails != null) { List<byte[]>
	 * imageList = propertyDetails.getBase64Images(); if (imageList != null &&
	 * !imageList.isEmpty()) { // Convert the first image from byte[] to
	 * Base64-encoded string byte[] firstImageBytes = imageList.get(0); // Assuming
	 * you want to process the first image String base64Image =
	 * Base64.getEncoder().encodeToString(firstImageBytes);
	 * auction.setBase64Image(base64Image); // Assuming AuctionEntity has a field to
	 * store Base64 image
	 * 
	 * // Log message to indicate successful decoding of image
	 * System.out.println("Decoded image for auction ID: " + auction.getId()); }
	 * else { // Log message for no image found
	 * System.out.println("No images found for auction ID: " + auction.getId()); } }
	 * else { // Log message for null PropertyDetails
	 * System.out.println("PropertyDetails is null for auction ID: " +
	 * auction.getId()); } }
	 * 
	 * // Add allAuctionDetails to the model for Thymeleaf rendering
	 * model.addAttribute("allAuctionDetails", allAuctionDetails);
	 * 
	 * // Return the view name return "PropertyAuctionDetail"; }
	 */

    @GetMapping("/search")
    public List<AuctionEntity> searchAuctions(
        @RequestParam long auctionId,
        @RequestParam String category,
        @RequestParam String state,
        @RequestParam String city,
        @RequestParam String bank) {

        return auctionServices.searchProperties(auctionId, category, state, city, bank);
    }

}
    
    
   
