package com.stackroute.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonAddressDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private double lng;
	private double lat;
	private String city;
	private int pincode;
	

}
