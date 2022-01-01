package week3.day1;

import java.io.File;

//import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class LearnSchemaValidate {
	
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
		
		//File file = new File("./data/JSONSchema.json");
		File file = new File("./data/JSONSchemaGenerated.json");
		
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
								.body(JsonSchemaValidator.matchesJsonSchema(file))
								.extract().response();
		
		response.then().log().all();
		System.out.println(response.getStatusLine());
		System.out.println(response.jsonPath().get("result.sys_id"));
		System.out.println(response.asPrettyString());
	}
	
}