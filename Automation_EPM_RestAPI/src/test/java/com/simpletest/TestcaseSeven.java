package com.simpletest;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.BaseClass;

import io.restassured.response.Response;

public class TestcaseSeven {

	
	@Test(description = "Verify that non Existing planetID gives 404 status ")
	public void test_7() {
		BaseClass base =new BaseClass();
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
