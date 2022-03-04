package com.ami.api.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ami.api.model.Token;

@Repository
public class CustomRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public Token getToken(String email) {
		String sql = "SELECT * FROM token where email = :email";
		Query query = em.createNativeQuery(sql, Token.class)
				.setParameter("email", email);
		Token token = (Token) query.getSingleResult();
		return token;
	}
	
	@Transactional
	public void addToken(Token token) {
		em.persist(token);
	}

}
