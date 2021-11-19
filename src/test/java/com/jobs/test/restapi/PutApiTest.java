package com.jobs.test.restapi;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jobs.Apiconfig;
import jobs.ExcelInput;

public class PutApiTest {
  
  @DataProvider
	public Object[][] getCreateProgramApiData() throws Exception {

		Object[][] testObjArray = ExcelInput
				.getDataFromSheet(Apiconfig.DATA_FILE, "PutData");

		return (testObjArray);
	}

  @Test(dataProvider = "getCreateProgramApiData")
	public void testCreateProgram(String JobId ,String JobTitle, String JobLocation, String JobCompanyName,String JobType,String JobPostedtime, String JobDescription) {

		 RestAssured.given()
		  .queryParam("Job Id", JobId)
		  .queryParam("Job Title", JobTitle)
		  .queryParam("Job Location", JobLocation)
		  .queryParam("Job Company Name", JobCompanyName)
		  .queryParam("Job Type", JobType)
		  .queryParam("Job Posted time", JobPostedtime)
		  
		  .when().put(Apiconfig.BASE_URL + "/Jobs")
		  .then().statusCode(200).log().all().toString();
	}
		
	

	

	
}
