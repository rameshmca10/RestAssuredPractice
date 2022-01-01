package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIssue {

	@Test
	public void createIssue() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YPJHjeqybIuJ2FwpweGYD1FC");

		Response response = RestAssured.given().contentType(ContentType.JSON).log().all().body("{\r\n"
				+ "    \"fields\": {\r\n" + "        \"project\": {\r\n" + "            \"key\": \"RA\"\r\n"
				+ "        },\r\n" + "        \"summary\": \"create issue in RA project iwth variables\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "        \"issuetype\": {\r\n" + "            \"name\": \"Bug\"\r\n" + "        }\r\n" + "    }\r\n"
				+ "}").post();

		System.out.println("Id Created: " + response.jsonPath().getString("id"));

	}

}