package com.tests;

import static io.restassured.RestAssured.get;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.extentreport.BaseExtentReport;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.actions.BaseClass;


public class APICodeTest extends BaseExtentReport {

	AtomicBoolean data = new AtomicBoolean(false);

	BaseClass base =new BaseClass();
	
	
	
	@Test(description = "Verify that System gives 200 status for the endpoint")
	public void test_01() {
		base.loadApiUrl();
		Response response = get();

		System.out.println("Got response::" + response.getStatusCode());

		Assert.assertEquals(get().statusCode(), 200);

	}

	@Test(description = "Verify that System gives json body response for all the planets")
	public void test_02() {

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

	@Test(description = "Verify that following attributes are available in all planetNames")
	public void test_03() {

		base.loadApiUrl();

		Response response = get();
		List<Map<String, Object>> jsonList = response.jsonPath().get("results");
		System.out.println(jsonList.size());

		for (int i = 0; i < jsonList.size(); i++) {

			for (Map.Entry<String, Object> entry : jsonList.get(i).entrySet()) {
				String key = entry.getKey();
				// Object value = entry.getValue();

				if (key.equalsIgnoreCase("name")) {
					data.set(true);

				}

				if (key.equalsIgnoreCase("rotation_period")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("orbital_period")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("diameter")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("climate")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("gravity")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("terrain")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("population")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("residents")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("films")) {
					data.set(true);
				}
				if (key.equalsIgnoreCase("created")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("edited")) {
					data.set(true);
				}

				if (key.equalsIgnoreCase("url")) {
					data.set(true);
				}

				if (data.get() == true ) {
					System.out.println("Result record No::" + i
							+ "::contains:: name ,rotation_period,orbital_period,diameter,climate,gravity,terrain, population, residents,films,created, edited,url");
					break;
				}

			}
		}

		int sizeOfRecords = get().body().path("results.size()");
		int sizeOfName = get().body().path("results.name.size()");
		Assert.assertEquals(sizeOfRecords, sizeOfName, "Name found in all result record");

		int sizeOfrotation_period = get().body().path("results.rotation_period.size()");
		Assert.assertEquals(sizeOfRecords, sizeOfrotation_period, "rotation_period found in all result record");

		int sizeOforbital_period = get().body().path("results.orbital_period.size()");
		Assert.assertEquals(sizeOfRecords, sizeOforbital_period, "orbital_period found in all result record");

		int diameter = get().body().path("results.diameter.size()");
		Assert.assertEquals(sizeOfRecords, diameter, "diameter found in all result record");

		int climate = get().body().path("results.climate.size()");
		Assert.assertEquals(sizeOfRecords, climate, "climate found in all result record");

		int gravity = get().body().path("results.gravity.size()");
		Assert.assertEquals(sizeOfRecords, gravity, "gravity found in all result record");

		int terrain = get().body().path("results.terrain.size()");
		Assert.assertEquals(sizeOfRecords, terrain, "terrain found in all result record");

		int population = get().body().path("results.population.size()");
		Assert.assertEquals(sizeOfRecords, population, "population found in all result record");

		int residents = get().body().path("results.residents.size()");
		Assert.assertEquals(sizeOfRecords, residents, "residents  found in all result record");

		int films = get().body().path("results.films.size()");
		Assert.assertEquals(sizeOfRecords, films, "films found in all result record");

		int created = get().body().path("results.created.size()");
		Assert.assertEquals(sizeOfRecords, created, "created  found in all result record");

		int edited = get().body().path("results.edited.size()");
		Assert.assertEquals(sizeOfRecords, edited, "edited found in all result record");

		int url = get().body().path("results.url.size()");
		Assert.assertEquals(sizeOfRecords, url, "url found in all result record");

	}

	@Test(description = "Verify that Total Count value is present in response")
	public void test_04() {
		base.loadApiUrl();
		int countOfRecords = get().path("count");
		// System.out.println(countOfRecords);
		Assert.assertEquals(countOfRecords, 61, " Total Count value is present in response");

	}

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

	@Test(description = "Verify that Single Planet Name Has Satisfy TC 1 - 3")
	public void test_06() {

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

	@Test(description = "Verify that non Existing planetID gives 404 status ")
	public void test_7() {
		base.nonExistingplanetIDUrl();
		Response response = get();
		System.out.println("Got response::" + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 404);
		String responseJson = get().getBody().asString();
		System.out.println(">>>>>>>>>>>" + responseJson);

		String statusLine = response.getStatusLine();
		System.out.println(statusLine);

	}

}
