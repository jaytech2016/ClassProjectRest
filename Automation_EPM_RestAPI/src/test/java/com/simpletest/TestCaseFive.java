package com.simpletest;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TestCaseFive {

	
	@Test(description = "Verify that total count match with total PlanetNames available in all Pages")
	public void test_05() {

		int sumplanet = 0;
		int countOfPlanets = 0;
		for (int i = 1; i < 15; i++) {

			Response response1 = get("https://swapi.co/api/planets/?page=" + i + "");
			String next = response1.jsonPath().getString("next");
			countOfPlanets = response1.path("count");
			System.out.println("NEXT ::" + next);
			int sizeOfName1 = response1.path("results.name.size()");
			sumplanet = sizeOfName1 + sumplanet;

			if (next == null) {
				break;
			}

		}

		System.out.println("Total planet::" + sumplanet);

		Assert.assertEquals(sumplanet, countOfPlanets,
				"total count match with total PlanetNames available in all Pages");

	}
}
