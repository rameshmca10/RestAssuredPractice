package week3.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnAssertions {
	
	//@Test
	public void getAllIncidents() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		Response response = RestAssured
				.get()
				.then()
				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.response();

		System.out.println(response.prettyPrint());

		System.out.println(response.getStatusLine());
	}

	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
		
		Response response = RestAssured
								.given()
								.contentType(ContentType.JSON)
								.body("{\r\n"
										+ "    \"short_description\":\"Assertion\",\r\n"
										+ "    \"description\":\"created from ppostman\"\r\n"
										+ "}")
								.post()
								.then()
								.assertThat()
								.body("result.short_description", Matchers.equalTo("Assertion"))
								.body("result.short_description", Matchers.containsString("Assert"))
								.body("result", Matchers.hasItem("sys_updated_on"))
								.extract().response();
		
		response.then().log().all();
		System.out.println(response.getStatusLine());
		System.out.println(response.jsonPath().get("result.sys_id"));
		System.out.println(response.asPrettyString());
	}
	
}