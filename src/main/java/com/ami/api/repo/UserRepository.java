package com.ami.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ami.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findUserByEmail(String email);
}
