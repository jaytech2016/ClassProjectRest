package com.basicAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseParamValidation {

	@Test
	public void WeatherMessageBody()
	{
	RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("New York");
 
	// First get the JsonPath object instance from the Response interface
	JsonPath jsonPathEvaluator = response.jsonPath();
 
	// Then simply query the JsonPath object to get a String value of the node
	// specified by JsonPath: City (Note: You should not put $. in the Java code)
	String city = jsonPathEvaluator.get("City");
 
	// Let us print the city variable to see what we got
	System.out.println("City received from Response::: " + city);
 
	// Validate the response
	Assert.assertEquals(city, "New York", "Correct city name received in the Response");
 
}
}