package com.ami.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ami.api.http.CustomHTTP;

@SpringBootApplication
@ComponentScan(basePackages = "com.ami.api")
public class ApiGetPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetPostApplication.class, args);
		// internally call external api to test
		// CustomHTTP cstHttp = new CustomHTTP();
		// String url = "http://localhost:8081/ExternalApiCall";
		// cstHttp.httpPost(url);
	}

}
