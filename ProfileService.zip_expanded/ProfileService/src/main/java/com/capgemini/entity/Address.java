package com.capgemini.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.DTO.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="houseNumber")
	private int houseNumber;
	
	@Column(name="streetName")
	private String streetName;
	
	@Column(name="colonyName")
	private String colonyName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private int pincode;
	
	
	
	public Address(AddressDTO addressDTO) {
		this.id = addressDTO.getId();
		this.houseNumber = addressDTO.getHouseNumber();
		this.streetName = addressDTO.getStreetName();
		this.colonyName = addressDTO.getColonyName();
		this.city = addressDTO.getState();
		this.pincode = addressDTO.getPincode();
	}

}
