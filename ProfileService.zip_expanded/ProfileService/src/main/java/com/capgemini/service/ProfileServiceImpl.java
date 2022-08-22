package com.capgemini.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.capgemini.DTO.UserProfileDTO;
import com.capgemini.entity.UserProfile;
import com.capgemini.repository.ProfileRepository;
@ComponentScan(basePackages = "com.capgemini.repository")
@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	


@Override
public UserProfileDTO addNewCustomerProfile(UserProfileDTO userProfileDTO) {
	UserProfile userProfile = new UserProfile(userProfileDTO);
	return new UserProfileDTO(profileRepository.save(userProfile));
}

@Override
public List<UserProfileDTO> getAllProfiles() {
	List<UserProfile> userProfile = profileRepository.findAll();
	return userProfile.stream().map(UserProfileDTO::new).collect(Collectors.toList());
}

@Override
public UserProfileDTO getByProfileId(Integer profileId) {
	UserProfile userprofile = profileRepository.findById(profileId).orElseThrow();
	return new UserProfileDTO(userprofile);
}

@Override
public HttpStatus updateProfile(Integer profileId, UserProfileDTO userProfileDTO) {
	UserProfile userprofile = profileRepository.findById(profileId).orElseThrow();
	userprofile.setFullname(userProfileDTO.getFullname());
	userprofile.setEmailid(userProfileDTO.getEmailid());
	userprofile.setGender(userProfileDTO.getGender());
	userprofile.setAbout(userProfileDTO.getAbout());
	userprofile.setMobileNumber(userProfileDTO.getMobileNumber());
	userprofile.setAddress(userProfileDTO.getAddress());
	return null;
	
	
}

@Override
public void deleteProfile(Integer profileId) {
	UserProfile userprofile = profileRepository.findById(profileId).orElseThrow();
	profileRepository.delete(userprofile);
}

}
