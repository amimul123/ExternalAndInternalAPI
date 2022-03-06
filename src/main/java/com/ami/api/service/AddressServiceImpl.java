package com.ami.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ami.api.model.Address;
import com.ami.api.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepo;

	@Override
	public Address GetAddressByCity(String city) {
		
		return addressRepo.findAddressByCity(city);
	}

}
