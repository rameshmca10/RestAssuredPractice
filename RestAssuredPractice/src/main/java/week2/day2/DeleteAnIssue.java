package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteAnIssue {

	@Test
	private void deleteAnIssue() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YPJHjeqybIuJ2FwpweGYD1FC");

		Response response = RestAssured.given().contentType(ContentType.JSON).delete("22656");

		System.out.println(response.statusLine());

	}

}