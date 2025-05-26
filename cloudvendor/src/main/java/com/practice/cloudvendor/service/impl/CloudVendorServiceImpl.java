package com.practice.cloudvendor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.cloudvendor.Exception.CloudVendorNotFoundException;
import com.practice.cloudvendor.model.CloudVendor;
import com.practice.cloudvendor.repository.CloudVendorRepository;
import com.practice.cloudvendor.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
	@Autowired
	CloudVendorRepository cloudVendorRepository;

	@Override
	public String createCloudVendorDetails(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Successfully saved";
	}

	@Override
	public CloudVendor getCloudVendorById(String vendorId) {
		if(cloudVendorRepository.findById(vendorId).isEmpty())
			throw new CloudVendorNotFoundException("The Requested Cloud Vendor is not present");
		return 	cloudVendorRepository.findById(vendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorRepository.findAll();
	}

	@Override
	public String updateCloudVendorDetails(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Updated Successfully";
	}
    
	
	
	@Override
	public String deleteCloudVendorDetails(String vendorId) {
		cloudVendorRepository.deleteById(vendorId);
		return "Deleted Successfully";
	}

	@Override
	public List<CloudVendor> getCloudVendorByVendorPhone(String phoneNum) {
		if(cloudVendorRepository.findByVendorPhone(phoneNum).isEmpty())
			throw new CloudVendorNotFoundException("No cloud Vendor have the entered phone number"); 
		return cloudVendorRepository.findByVendorPhone(phoneNum)
				;
	}

	

}
