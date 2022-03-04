package com.ami.api.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ami.api.http.CustomHTTP;

@Controller
public class HTTPController {

	@RequestMapping("/")
	@ResponseBody
	public String Home() {
		return "Welcome API TEST";
	}

	@RequestMapping("/ExternalToken")
	@ResponseBody
	private String ExternalApiTest() {
		// internally call to test
		CustomHTTP cstHttp = new CustomHTTP();
		String url = "http://localhost:8081/api/AddToken";
		String response = cstHttp.httpPost(url);
		return response;
	}
	
	// call from main method to test
	@RequestMapping("/ExternalApiCall")
	@ResponseBody
	public String AddTokenRequest(@RequestBody String param) {
		try {
			JSONObject jsonData = (JSONObject) new JSONParser().parse(param);
			System.out.println("Controller: " + jsonData.get("param").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return param;
	}

}
