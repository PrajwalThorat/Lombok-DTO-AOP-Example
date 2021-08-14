package com.stackroute.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.model.Person;
import com.stackroute.model.PersonAddressDTO;
import com.stackroute.repo.PersonRepo;

@Service
public class DeliveryService {
	
	@Autowired
	private PersonRepo personRepo;
	

	private ModelMapper modelMapper = new ModelMapper();
	
	public List<PersonAddressDTO> getAllPersonAddress(){
		return ((List<Person>) personRepo.findAll()).stream().map(this::convertToPersonAddressDTO).collect(Collectors.toList());
	}
	
	private PersonAddressDTO convertToPersonAddressDTO(Person person) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		PersonAddressDTO personAddressDTO = modelMapper.map(person, PersonAddressDTO.class);
		return personAddressDTO;
	}
	
	public Optional<Person> findByPersonId(int id){
		return personRepo.findById(id);
	}
	
}
