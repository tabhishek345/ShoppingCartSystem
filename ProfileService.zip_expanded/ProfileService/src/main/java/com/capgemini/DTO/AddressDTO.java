package com.capgemini.DTO;

import com.capgemini.entity.Address;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	
    private int id;
	
	private int houseNumber;
	
	private String streetName;
	
	private String colonyName;
	
	private String city;
	
	private String state;
	
	private int pincode;
	
	public AddressDTO(Address address) {
		this.id = address.getId();
		this.houseNumber = address.getHouseNumber();
		this.streetName = address.getStreetName();
		this.colonyName = address.getColonyName();
		this.state = address.getState();
		this.pincode = address.getPincode();
	}

}
