package week5.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnWiremockRecording {

	@Test
	public void createIncidentWithoutBody() {
//			step1: get Url/ Endpoint
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
//			step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
//			step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.given().contentType(ContentType.JSON).post();
//			step4: print response body
		response.prettyPrint();
//			step5: print status code
		System.out.println(response.statusCode());

	}

}