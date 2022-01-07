package week5.day1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnStubJSONJira {

	@BeforeMethod
	public void stubSample() {
		stubFor(post("/rest/api/2/issue")
				.willReturn(aResponse().withStatus(201).withHeader("content-type", "application/json")
						.withBody("{\r\n" + "    \"id\": \"23192\",\r\n" + "    \"key\": \"RA-12363\",\r\n"
								+ "    \"self\": \"https://api-may2020.atlassian.net/rest/api/2/issue/23192\"\r\n"
								+ "}")));
	}

	@Test
	public void createIncidentWithoutBody() {

//		step1: get Url/ Endpointhttps://api-may2020.atlassian.net/rest/api/2/issue/
		RestAssured.baseURI = "http://localhost:8080/rest/api/2/issue";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("hari.radhakrishnan@testleaf.com", "Yw7DXWGZBMY7UV6d52kF7F7C");

		File file = new File("./data/CreateAnIssue.json");
		// step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.given().contentType(ContentType.JSON).body(file).post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		response.then().statusCode(0);
	}

}