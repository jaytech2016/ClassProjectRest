package com.simpletest;

import static io.restassured.RestAssured.get;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.BaseClass;

import io.restassured.path.json.JsonPath;

public class TestCaseTwo {


	
	@Test(description = "Verify that System gives json body response for all the planets")
	public void test_02() {
		BaseClass base =new BaseClass();
		base.loadApiUrl();
		JsonPath path = get().body().jsonPath();
		String bodyAsString = get().body().asString();
		System.out.println(bodyAsString);
		Assert.assertFalse(bodyAsString.isEmpty());
		int sizeOfRecords = get().body().path("results.size()");
		int sizeOfName = get().body().path("results.name.size()");
		// System.out.println(sizeOfName+"::Total Name");
		Assert.assertEquals(sizeOfRecords, sizeOfName, "Planet name count matched with record number");

		List<String> allPlanetName = path.getList("results.name");

		for (String planet : allPlanetName) {

			Assert.assertTrue(path.getList("results").toString().contains("" + planet + ""), "found planet name");

		}

	}
}
