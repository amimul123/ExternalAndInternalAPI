package com.ami.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ami.api.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	public Address findAddressByCity(String city);
}
