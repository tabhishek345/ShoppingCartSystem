package com.capgemini.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.DTO.UserProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserProfile")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="profileid")
	private int profileid;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="emailid")
	private String emailid;
	
	@Column(name="mobileNumber")
	private Long mobileNumber;
	
	@Column(name="about")
	private String about;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@Column(name="gender")
	private String gender;
	
	
	
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="profileid", nullable=false)
	private List<Address> address ;



	@Override
	public String toString() {
		return "UserProfile [profileid=" + profileid + ", fullname=" + fullname + ", emailid=" + emailid
				+ ", mobileNumber=" + mobileNumber + ", about=" + about + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", address=" + address + "]";
	}

	public UserProfile(UserProfileDTO userProfileDTO) {
		this.profileid = userProfileDTO.getProfileid();
		this.fullname = userProfileDTO.getFullname();
		this.emailid = userProfileDTO.getEmailid();
		this.mobileNumber = userProfileDTO.getMobileNumber();
		this.about= userProfileDTO.getAbout();
		this.dateOfBirth = userProfileDTO.getDateOfBirth();
		this.gender = userProfileDTO.getGender();
		this.address = userProfileDTO.getAddress();
	}
	
	

}
