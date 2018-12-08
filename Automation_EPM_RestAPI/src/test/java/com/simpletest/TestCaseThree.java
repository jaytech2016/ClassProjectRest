package com.simpletest;

import static io.restassured.RestAssured.get;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.BaseClass;

import io.restassured.response.Response;

public class TestCaseThree {
	AtomicBoolean data = new AtomicBoolean(false);
	
	@Test(description = "Verify that following attributes are available in all planetNames")
	public void test_03() {
		BaseClass base =new BaseClass();
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

}
