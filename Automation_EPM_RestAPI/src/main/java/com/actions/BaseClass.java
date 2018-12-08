package com.actions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseClass {
	
	
	public void loadApiUrl() {
		RestAssured.baseURI = "http://swapi.co/api/planets";
	}
	
	public JsonPath getJsonPath(Response response) {
		return response.jsonPath();
	}

	public void singlePlanetUrl() {
		RestAssured.baseURI = "http://swapi.co/api/planets/11";
	}
	
	public void nonExistingplanetIDUrl() {
		RestAssured.baseURI = "http://swapi.co/api/planets/11x";
	}
	

}
