package week5.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnWiremockRecordingGetAllJira {

	@Test
	public void createIncidentWithoutBody() {
//			step1: get Url/ Endpoint
		RestAssured.baseURI = "http://localhost:8080/rest/api/2/search";
//			step2: Authentication (basic)
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"Yw7DXWGZBMY7UV6d52kF7F7C");
//			step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.given().log().all().get("?jql=project=RA");
//			step4: print response body
		response.prettyPrint();
//			step5: print status code
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.jsonPath().getString("issues[0].id"));
	}

}