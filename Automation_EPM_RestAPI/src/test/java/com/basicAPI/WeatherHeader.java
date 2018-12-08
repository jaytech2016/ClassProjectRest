package com.basicAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherHeader {

	@Test
	public void getheader() {
	
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("/New York");
 
	// Reader header of a give name. In this line we will get
	// Header named Content-Type
	String contentType = response.header("Content-Type");
	System.out.println("Content-Type value: " + contentType);
 
	// Reader header of a give name. In this line we will get
	// Header named Server
	String serverType =  response.header("Server");
	System.out.println("Server value: " + serverType);
 
	// Reader header of a give name. In this line we will get
	// Header named Content-Encoding
	String acceptLanguage = response.header("Content-Encoding");
	System.out.println("Content-Encoding: " + acceptLanguage);
	
	
	Headers allHeaders = response.headers();
	 
	// Iterate over all the Headers
	for(Header header : allHeaders)
	{
		System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	}
	
	
	Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
 
	// Reader header of a give name. In this line we will get
	// Header named Server
	
	Assert.assertEquals(serverType /* actual value */, "nginx/1.14.1" /* expected value */);
 
	// Reader header of a give name. In this line we will get
	// Header named Content-Encoding
	String contentEncoding = response.header("Content-Encoding");
	Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
	
	}
}
	

