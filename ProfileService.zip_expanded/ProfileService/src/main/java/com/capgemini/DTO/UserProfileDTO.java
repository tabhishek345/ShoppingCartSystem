package com.capgemini.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.capgemini.entity.Address;
import com.capgemini.entity.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {
	
	
    private int profileid;
	
    @NotBlank(message="Full Name Can't Be Blank or Null!!")
	@Size(min = 1,max = 100)
	private String fullname;
	
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	@Column(unique = true)
	private String emailid;
	
	private Long mobileNumber;
	
	private String about;
	
	private LocalDate dateOfBirth;
	
	private String gender;
	
	
	private List<Address> address;
	
	public UserProfileDTO (UserProfile userProfile) {
		this.profileid = userProfile.getProfileid();
		this.fullname = userProfile.getFullname();
		this.emailid = userProfile.getEmailid();
		this.mobileNumber = userProfile.getMobileNumber();
		this.about = userProfile.getAbout();
		this.dateOfBirth = userProfile.getDateOfBirth();
		this.gender = userProfile.getGender();
		this.address = userProfile.getAddress();
	}

}
