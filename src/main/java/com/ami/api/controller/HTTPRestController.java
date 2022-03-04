package com.ami.api.controller;

import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ami.api.model.Token;
import com.ami.api.service.TokenService;

@RestController
@RequestMapping("/api")
public class HTTPRestController {

	@Autowired
	TokenService tokenSevice;

	@GetMapping(path = "/Test/{id}", produces = "application/json")
	public JSONObject GetId(@PathVariable(name = "id") String id) {
		JSONObject response = new JSONObject();
		response.put("id", id);
		response.put("value", "Success");
		response.put("status", HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path = "/GetToken/{email}", produces = "application/json")
	public Token GetToken(@PathVariable(name = "email") String email) {
		return tokenSevice.getTokenByEmail(email);
	}
	
	@PostMapping(path = "/AddToken",consumes = "application/json", produces = "application/json")
	public JSONObject AddTokenRequest(@RequestBody String param) {
		JSONObject jsonData = null;
		try {
			jsonData = (JSONObject) new JSONParser().parse(param);
			tokenSevice.addTokenToDB((JSONObject) jsonData.get("param"));
			// System.out.println("Controller: " + jsonData.get("param").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonData;
	}

}
