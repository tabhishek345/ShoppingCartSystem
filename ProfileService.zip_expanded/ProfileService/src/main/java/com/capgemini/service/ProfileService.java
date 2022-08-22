package com.capgemini.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

import com.capgemini.DTO.UserProfileDTO;
@ComponentScan(basePackages = "com.capgemini.repository")
public interface ProfileService {
	
	UserProfileDTO addNewCustomerProfile(UserProfileDTO userProfileDTO);
	
	List<UserProfileDTO> getAllProfiles();
	
	UserProfileDTO getByProfileId(Integer profileId);
	
	HttpStatus updateProfile(Integer profileId,UserProfileDTO userProfileDTO);
	
	void deleteProfile(Integer profileId);
	
	

}
