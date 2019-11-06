package com.accenture.lkm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;

@RestController
public class VendorController {

	private static final Logger logger = LoggerFactory.getLogger(VendorController.class);
	
	/*
	 * Autowire the VendorService object
	 * 
	 * */
	@Autowired
	private VendorService service;
	// Your Code Here
	
	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot Vendor Service API!";
	}

	
	/* 
	 * Method - getVendorDetails()
	 * Fetch all the vendor details using VendorService and store it inside a List
	 * Return a ResponseEntity object passing the list of vendor details
	 * 
	 */
	
	@GetMapping("/vendor/controller/getVendors")
	public ResponseEntity<List<VendorBean>> getVendorDetails() {
		// Your Code Here
		List<VendorBean> vendorBeans = service.getVendorDetails();
		
		if(!vendorBeans.isEmpty())
			return new ResponseEntity<List<VendorBean>>(vendorBeans, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<List<VendorBean>>(vendorBeans, HttpStatus.NOT_FOUND);
	}
}
