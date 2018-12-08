package com.startAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;



public class ResponseValidation {

	@Test
	public  void start2() {
		Response response=  get("https://samples.openweathermap.org/data/2.5/weather?q=london,us&appid=25e4fc6e6b2e357a177262c7005");
		System.out.println(response.statusCode());
	
		
		if(response.statusCode() == 200) {
			System.out.println("Test passed::"+response.statusCode());
		}
		else {
			System.out.println("test failed");
		}
		Assert.assertEquals(response.statusCode(), 200);
		
		}
	}

