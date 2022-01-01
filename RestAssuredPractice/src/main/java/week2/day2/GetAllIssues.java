package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllIssues {

	@Test
	private void getAllIssues() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search?jql=project=RA'";

		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YPJHjeqybIuJ2FwpweGYD1FC");

		Response response = RestAssured.given().accept(ContentType.JSON).get();

		System.out.println(response.asPrettyString());
	}

}