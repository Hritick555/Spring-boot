package com.practice.cloudvendor.service;

import java.util.List;
import java.util.Optional;

import com.practice.cloudvendor.model.CloudVendor;

public interface CloudVendorService {
  public String createCloudVendorDetails(CloudVendor cloudVendor);
  public CloudVendor getCloudVendorById(String vendorId);
  public List<CloudVendor> getAllCloudVendorDetails();
  public String updateCloudVendorDetails(CloudVendor cloudVendor);
  public String deleteCloudVendorDetails(String vendorId);
  public List<CloudVendor> getCloudVendorByVendorPhone (String phoneNum);
}
