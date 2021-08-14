package com.stackroute.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {
	@Id
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	
	
	@ManyToOne(fetch = FetchType.EAGER , optional = false)
	@JoinColumn(name = "address_id")
	private Address address;
}
