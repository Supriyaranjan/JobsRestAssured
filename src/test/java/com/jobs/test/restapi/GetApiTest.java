package com.jobs.test.restapi;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jobs.Apiconfig;
import jobs.ExcelInput;

public class GetApiTest {
  
 
	@Test
	public void testGetAllPrograms() {
		Response response = given().when().get(Apiconfig.BASE_URL + "/Jobs"); // This will
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200, "Response received successfully");
		


	}

	
}
