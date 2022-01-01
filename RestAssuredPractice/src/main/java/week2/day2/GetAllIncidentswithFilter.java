package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentswithFilter {
	@Test
	public void getAllIncidents() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		RequestSpecification inputRequest = RestAssured.given().queryParam("sysparm_fields",
				"sys_id, category, number");

		Response response = inputRequest.get();

		System.out.println(response.prettyPrint());

		System.out.println(response.getStatusLine());
	}
}