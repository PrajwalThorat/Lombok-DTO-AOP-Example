package com.stackroute.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.model.Person;
import com.stackroute.model.PersonAddressDTO;
import com.stackroute.service.DeliveryService;

@RestController
@RequestMapping("api/v1/person")
public class MyController {
	
	private DeliveryService deliveryService;
	
	public MyController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	@GetMapping("welcome")
	public String viewPage() {
		return "Welcome to DTO-AOP example";
	}
	
	@GetMapping("delivery")
	public List<PersonAddressDTO> getAllPersonAddress(){
		List<PersonAddressDTO> personAddressDTO = deliveryService.getAllPersonAddress();
		return personAddressDTO;
	}
	
	@GetMapping("{id}")
	public Optional<Person> getPersonById(@PathVariable int id){
		return deliveryService.findByPersonId(id);
	}
}
