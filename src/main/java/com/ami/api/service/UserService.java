package com.ami.api.service;

import org.springframework.stereotype.Component;

import com.ami.api.model.User;

@Component
public interface UserService {
	public User addTestUser();
	public User addUser(User user);
	public User findUserByEmail(String email);

}
