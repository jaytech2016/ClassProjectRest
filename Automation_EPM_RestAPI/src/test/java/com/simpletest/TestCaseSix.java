package com.simpletest;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.BaseClass;

import io.restassured.response.Response;

public class TestCaseSix {

	
	@Test(description = "Verify that Single Planet Name Has Satisfy TC 1 - 3")
	public void test_06() {
		BaseClass base =new BaseClass();
		// TC 1
		base.singlePlanetUrl();
		Response response = get();

		System.out.println("Got response Single Planet::" + response.getStatusCode());

		Assert.assertEquals(get().statusCode(), 200);

		// TC 2

		String bodyAsString = get().body().asString();
		System.out.println(bodyAsString);
		Assert.assertFalse(bodyAsString.isEmpty());

		String planetName = get().body().path("name");
		System.out.println(planetName);

		Assert.assertTrue(bodyAsString.contains("name"));

		// TC 3

		Assert.assertTrue(bodyAsString.contains("name"));
		Assert.assertTrue(bodyAsString.contains("rotation_period"));
		Assert.assertTrue(bodyAsString.contains("orbital_period"));
		Assert.assertTrue(bodyAsString.contains("diameter"));
		Assert.assertTrue(bodyAsString.contains("climate"));
		Assert.assertTrue(bodyAsString.contains("gravity"));
		Assert.assertTrue(bodyAsString.contains("terrain"));
		Assert.assertTrue(bodyAsString.contains("population"));
		Assert.assertTrue(bodyAsString.contains("residents"));
		Assert.assertTrue(bodyAsString.contains("films"));
		Assert.assertTrue(bodyAsString.contains("created"));
		Assert.assertTrue(bodyAsString.contains("edited"));
		Assert.assertTrue(bodyAsString.contains("url"));

	}
}
