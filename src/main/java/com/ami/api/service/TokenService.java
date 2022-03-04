package com.ami.api.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ami.api.model.Token;
import com.ami.api.repo.CustomRepository;

@Service
public class TokenService {
	
	@Autowired
	CustomRepository ctmRepo;
	
	public Token getTokenByEmail(String email) {
		return ctmRepo.getToken(email); 
	}
	
	public void addTokenToDB(JSONObject data) {
		Token token = new Token();
		token.setAuth(data.get("auth").toString());
		token.setEmail(data.get("email").toString());
		token.setOrigin(data.get("origin").toString());
		ctmRepo.addToken(token);
	}
}
