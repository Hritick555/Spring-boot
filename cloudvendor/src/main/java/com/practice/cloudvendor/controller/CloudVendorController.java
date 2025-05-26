package com.practice.cloudvendor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.cloudvendor.model.CloudVendor;
import com.practice.cloudvendor.response.ResponseHandler;
import com.practice.cloudvendor.service.CloudVendorService;
import com.practice.cloudvendor.service.impl.CloudVendorServiceImpl;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	@Autowired
	CloudVendorServiceImpl cloudVendorServiceImpl;
  
	@PostMapping
	public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		return cloudVendorServiceImpl.createCloudVendorDetails(cloudVendor);
	}
	
	@PutMapping
	public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {
		return cloudVendorServiceImpl.updateCloudVendorDetails(cloudVendor);
	}
	
	@GetMapping("{vendorId}")
	public ResponseEntity<Object> getCloudVendorById(@PathVariable(name = "vendorId")String vendorId) {//If we've multiple pathVariable use name attribute
		return ResponseHandler.responseBuilder("The requested vendor id is provided", HttpStatus.OK, cloudVendorServiceImpl.getCloudVendorById(vendorId));
	}
	
	@GetMapping("/phone/{phoneNum}")
	public ResponseEntity<Object> getCloudVendorByPhoneNumber(@PathVariable String phoneNum) {
		return ResponseHandler.responseBuilderForPhone("The vendor id related to phone", cloudVendorServiceImpl.getCloudVendorByVendorPhone(phoneNum), HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public List<CloudVendor> getAllCloudVendor(){
		return cloudVendorServiceImpl.getAllCloudVendorDetails();
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendor(@PathVariable(name="vendorId")String vendorId) {
		return cloudVendorServiceImpl.deleteCloudVendorDetails(vendorId);
	}
}
