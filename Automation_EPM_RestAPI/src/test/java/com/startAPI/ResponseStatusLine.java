package com.startAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseStatusLine {

	public static void main(String[] args) {
		Response response=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=london,us&appid=25e4fc6e6b2e357a177262c7005");
		
		System.out.println(response.getStatusLine());

	}

}
