package com.practice.cloudvendor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.cloudvendor.model.CloudVendor;

@Repository
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
	List<CloudVendor> findByVendorPhone(String vendorPhone);  
	/*
FindBy{PropertyName(Here VendorPhone in entity class} ->So we're writing as findByPhoneNumber
	 
Optional Class is used to throw exception .Suppose if we need to throw exception if we didn't found phoneNumber.We've to use Optional

The Optional class in Java (introduced in Java 8) is a container object that may or may not contain a non-null value.It is widely 
used in Spring applications to handle cases where a value might be absent, avoiding NullPointerException and making the code more 
readable and expressive.
*/
}
