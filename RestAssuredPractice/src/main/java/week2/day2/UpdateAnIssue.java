package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateAnIssue {

	@Test
	private void updateAnIssue() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YPJHjeqybIuJ2FwpweGYD1FC");

		Response response = RestAssured.given().contentType(ContentType.JSON).log().all().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"description\": \"Issue updated via RestAssured on Oct 21 2021 --second time\"\r\n"
				+ "    }\r\n"
				+ "}").put("22656");

		System.out.println(response.statusLine());

	}

}