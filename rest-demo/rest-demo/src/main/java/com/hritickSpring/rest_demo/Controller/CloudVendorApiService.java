package com.hritickSpring.rest_demo.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hritickSpring.rest_demo.Model.CloudVendorApi;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorApiService {
	
	CloudVendorApi cloudVendor;

	@GetMapping("{vendorId}")	
	public CloudVendorApi getCloudvendorDetails(String v) {
		return cloudVendor;
		
	}
	
	@PostMapping
	public String createCloudVendorDetails(@RequestBody CloudVendorApi cloudVendor) {
		this.cloudVendor=cloudVendor;
		return "Created successfully";
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendorApi cloudVendor) {
		this.cloudVendor=cloudVendor;
		return "Updated successfully";
	}
	
	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(String vendorId) {
		this.cloudVendor=null;
		return "Deleted successfully";
	}
}
