package com.startAPI;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseTime {

	public static void main(String[] args) {
		Response response=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=london,us&appid=25e4fc6e6b2e357a177262c7005");
		
		//System.out.println(response.getStatusCode());
		//Assert.assertEquals(response.getStatusCode(), 200);
		
		
		System.out.println(response.getTime());
		//System.out.println(response.getStatusLine());
		//System.out.println(response.asString());
	//	System.out.println("======================");
		//System.out.println(response.getBody().prettyPrint());
	}

}
