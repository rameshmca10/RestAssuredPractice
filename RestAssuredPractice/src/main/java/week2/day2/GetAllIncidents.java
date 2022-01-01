package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {

	@Test
	public void getAllIncidents() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		Response response = RestAssured.get();

		System.out.println(response.prettyPrint());

		System.out.println(response.getStatusLine());
	}

}