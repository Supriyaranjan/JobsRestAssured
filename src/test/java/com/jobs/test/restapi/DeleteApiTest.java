package com.jobs.test.restapi;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jobs.Apiconfig;
import jobs.ExcelInput;

public class DeleteApiTest {
	
	 @DataProvider
		public Object[][] getCreateProgramApiData() throws Exception {

			Object[][] testObjArray = ExcelInput
					.getDataFromSheet(Apiconfig.DATA_FILE, "PutData");

			return (testObjArray);
		}

		@Test(dataProvider = "getCreateProgramApiData")
		public void testCreateProgram(String JobId ,String JobTitle, String JobLocation, String JobCompanyName,String JobType,String JobPostedtime, String JobDescription) {

			 RestAssured.given().baseUri(Apiconfig.BASE_URL )
			  .queryParam("Job Id", JobId)
			  .when().delete("/Jobs")
			  .then().statusCode(200);
			 
		}
}
