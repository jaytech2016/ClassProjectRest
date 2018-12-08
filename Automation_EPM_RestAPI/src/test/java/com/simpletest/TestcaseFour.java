package com.simpletest;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actions.BaseClass;

public class TestcaseFour {

	
	@Test(description = "Verify that Total Count value is present in response")
	public void test_04() {
		BaseClass base =new BaseClass();
		base.loadApiUrl();
		int countOfRecords = get().path("count");
		// System.out.println(countOfRecords);
		Assert.assertEquals(countOfRecords, 61, " Total Count value is present in response");

	}
}
