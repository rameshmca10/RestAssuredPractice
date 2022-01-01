package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBody {
	@Test
	public void createIncident() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
		
		Response response = RestAssured
								.given()
								.contentType(ContentType.JSON)
								.log()
								.all()
								.body("{\r\n"
										+ "    \"short_description\":\"Created with postman\",\r\n"
										+ "    \"description\":\"created from ppostman\"\r\n"
										+ "}")
								.post();
		
		response.then().log().all();
		System.out.println(response.getStatusLine());
		System.out.println(response.jsonPath().get("result.sys_id"));
		System.out.println(response.asPrettyString());
	}

}