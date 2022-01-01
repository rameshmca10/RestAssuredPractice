package week3.day1;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChainingRequests {

	private String id;

	@DataProvider
	public String[] getFiles() {

		String[] files = new String[2];

		files[0] = "./data/CreateAnIssue1.json";
		files[1] = "./data/CreateAnIssue2.json";
		return files;
	}

	@Test(dataProvider = "getFiles")
	public void createIssues(String str) {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";

		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YB8C8wwyjhmmfnE6SaNzB99D");

		File jsonFile = new File(str);

		// File jsonSchemaFile = new File("./data/IssueJSONSchema.json");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonFile).post().then().assertThat()
				.contentType(ContentType.JSON).statusCode(201).extract().response();

		id = response.jsonPath().getString("id");

		System.out.println(response.asPrettyString());

	}

	@Test(dependsOnMethods = "createIssues")
	public void updateAnIssue() {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";

		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YB8C8wwyjhmmfnE6SaNzB99D");

		File jsonFile = new File("./data/UpdateAnIssue.json");

		System.out.println("update ID: " + id);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonFile).put(id).then().assertThat()
				.contentType(ContentType.JSON).statusCode(204).extract().response();

		System.out.println(response.statusLine());
	}

	@Test(dependsOnMethods = "updateAnIssue")
	public void deleteAnIssue() {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";

		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YB8C8wwyjhmmfnE6SaNzB99D");

		System.out.println("delete ID: " + id);

		Response response = RestAssured.given().delete(id).then().assertThat().contentType(ContentType.JSON)
				.statusCode(204).extract().response();

		System.out.println(response.statusLine());
	}

}