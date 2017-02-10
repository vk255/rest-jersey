package com.hascode.tutorial.rest;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class UserServiceTestUsingJerseyIntegrationTestFramework extends JerseyTest {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

	@Test
	public void testUserFetchesSuccess() throws JSONException,
			URISyntaxException {
		WebResource webResource = client().resource("http://localhost:8080/");
		JSONObject json = webResource.path("/rest-test-tutorial/user/id/12")
				.get(JSONObject.class);
		assertEquals("12", json.get("id"));
		assertEquals("Tim", json.get("firstName"));
		assertEquals("Tester", json.get("lastName"));
	}

	@Test(expected = UniformInterfaceException.class)
	public void testUserNotFound() {
		WebResource webResource = client().resource("http://localhost:8080/");
		JSONObject json = webResource.path("/rest-test-tutorial/user/id/666")
				.get(JSONObject.class);
	}
}
