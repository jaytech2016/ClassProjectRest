package com.simpletest;

import static io.restassured.RestAssured.get;

import java.util.concurrent.atomic.AtomicBoolean;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.BaseClass;
import com.extentreport.BaseExtentReport;

import io.restassured.response.Response;

public class TestCaseOne {



	
	
	
	
	@Test(description = "Verify that System gives 200 status for the endpoint")
	public void test_01() {
		BaseClass base =new BaseClass();
		base.loadApiUrl();
		Response response = get();

		System.out.println("Got response::" + response.getStatusCode());

		Assert.assertEquals(get().statusCode(), 200);

	}
}