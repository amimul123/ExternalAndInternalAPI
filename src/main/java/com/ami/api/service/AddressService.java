package com.ami.api.service;

import org.springframework.stereotype.Component;

import com.ami.api.model.Address;

@Component
public interface AddressService {
	public Address GetAddressByCity(String city);
}
