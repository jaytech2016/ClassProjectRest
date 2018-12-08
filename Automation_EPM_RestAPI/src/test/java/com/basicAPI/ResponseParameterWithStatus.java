package com.basicAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseParameterWithStatus {
	@Test
	public void AuthenticationBasics()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("New York");
		
		System.out.println("Status code: " + response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		
		
		System.out.println("Status message " + response.body().asString());
	}
}
