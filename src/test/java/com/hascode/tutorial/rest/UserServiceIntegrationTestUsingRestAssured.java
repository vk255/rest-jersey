package com.hascode.tutorial.rest;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class UserServiceIntegrationTestUsingRestAssured
{
	@Test
	public void testUserFetchesSuccess() {
		expect().body("id", equalTo("12")).body("firstName", equalTo("Tim"))
				.body("lastName", equalTo("Tester"))
				.when().get("/rest-test-tutorial/user/id/12");
	}

	@Test
	public void testUserNotFound() {
		expect().body(nullValue()).when()
				.get("/rest-test-tutorial/user/id/666");
	}
}
