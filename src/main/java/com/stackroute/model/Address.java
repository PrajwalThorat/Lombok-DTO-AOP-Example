package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {
	
	@Id
	private int id;
	private double lng;
	private double lat;
	private String city;
	private int pincode;
	private String discription;

}
