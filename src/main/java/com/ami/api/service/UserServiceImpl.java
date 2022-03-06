package com.ami.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ami.api.model.Address;
import com.ami.api.model.User;
import com.ami.api.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User addTestUser() {

		User user = new User();
		user.setfName("Jhon");
		user.setlName("Adam");
		user.setEmail("jhon.adam@nooo.com");
		user.setGender("Male");
		user.setDob(LocalDate.parse("2010-12-10"));

		// a user could have one or multiple address like present, permanent, mailing
		// etc.
		List<Address> addresses = new ArrayList<>();
		Address address = new Address("street01", "houseNo01", "city01", "postcode01", "DE", "present", user);
		addresses.add(address);
		user.setAddresses(addresses);

		// save to database
		user = userRepo.save(user);
		return user;
	}

	@Override
	public User addUser(User user) {
		
		User tempUser = new User(user.getfName(),
				user.getlName(),
				user.getGender(),
				user.getDob(),
				user.getEmail());
		List<Address> tempAdds = new ArrayList<>();
		for (Address address : user.getAddresses()) {
			tempAdds.add(new Address(address.getStreet(),
					address.getHouseNo(),
					address.getCity(),
					address.getPostCode(),
					address.getCountry(),
					address.getType(),
					tempUser));
		}
		tempUser.setAddresses(tempAdds);
		return tempUser = userRepo.save(tempUser);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

}
