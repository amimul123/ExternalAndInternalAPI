package com.ami.api.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;


public class CustomHTTP {
	
	// call to external API by POST request with parameter
	public String httpPost(String apiUrl) {
		
		StringBuilder responseText = new StringBuilder();
		
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);
			
			JSONObject param = new JSONObject();
			param.put("auth", "20122");
			param.put("email", "email@ok.com");
			param.put("origin", "DE");
			JSONObject jsObject = new JSONObject();
			jsObject.put("param", param);
			byte[] paramByte = jsObject.toJSONString().getBytes(Charset.forName("UTF-8"));
			// System.out.println(jsObject.toJSONString());
			
			OutputStream outStream = connection.getOutputStream();
			outStream.write(paramByte, 0, paramByte.length);
			outStream.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
			String line = null;
			while( (line =reader.readLine()) != null) {
				responseText.append(line);
			}
			System.out.println("Class: " + responseText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseText.toString();
	}

}
