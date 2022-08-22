package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import com.capgemini.DTO.UserProfileDTO;
import com.capgemini.service.ProfileService;
@ComponentScan(basePackages = "com.capgemini.service")
@ComponentScan(basePackages = "com.capgemini.repository")
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
	
	@Autowired
	private ProfileService profileservice;
	
	@GetMapping("/getall")
	public List<UserProfileDTO> userProfile(){
		return profileservice.getAllProfiles();
	}
	
	@GetMapping("/get/{profileId}")
	public UserProfileDTO ByProfileId(@PathVariable Integer profileId) {
		return profileservice.getByProfileId(profileId);
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserProfileDTO> save(@Valid @RequestBody UserProfileDTO user){
		return new ResponseEntity<UserProfileDTO>(profileservice.addNewCustomerProfile(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{profileId}")
	public ResponseEntity<UserProfileDTO> update(@PathVariable Integer profileId,@RequestBody UserProfileDTO user){
		
		return new ResponseEntity<UserProfileDTO>(profileservice.updateProfile(profileId, user));
	}
	
	@DeleteMapping("/delete/{profileId}")
	public String deleteAll(@PathVariable Integer profileId) {
		profileservice.deleteProfile(profileId);
		return "Deleted The Profile Id";
	}
	

}
