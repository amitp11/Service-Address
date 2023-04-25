package com.example.address.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address.entity.Address;
import com.example.address.repository.AddressRepository;
import com.example.address.request.CreateAddressRequest;
import com.example.address.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		
		addressRepository.save(address);
		
		return new AddressResponse(address);
	}
	
	public AddressResponse getById(long id) {
		logger.info("Inside getById "+id);
		
		Address address = addressRepository.findById(id).get();
		
		return new AddressResponse(address);
	}

}
