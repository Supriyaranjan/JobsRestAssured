package com.jobs.test.restapi;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jobs.Apiconfig;
import jobs.ExcelInput;


public class PostApiTest {
	
	@DataProvider
	
	public Object[][] getCreateProgramApiData() throws Exception {

		Object[][] testObjArray = ExcelInput
				.getDataFromSheet(Apiconfig.DATA_FILE, "PostData");

		return (testObjArray);
		
	}

	@Test(dataProvider = "getCreateProgramApiData")
	public void testCreateProgram(String JobId, String JobTitle, String JobLocation, String JobCompanyName,String JobType,String JobPostedtime, String JobDescription) {

		
		
		Response response = given()
				.queryParam("Job Id",  JobId )
				  .queryParam("Job Title", JobTitle)
				  .queryParam("Job Location", JobLocation)
				  .queryParam("Job Company Name", JobCompanyName)
				  .queryParam("Job Type", JobType)
				  .queryParam("Job Posted time", JobPostedtime)
				  .queryParam("Job Description", JobDescription)
				.when().post(Apiconfig.BASE_URL + "/Jobs");
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);


	}
}
