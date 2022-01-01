package week3.day1;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateAndDeleteAnIssue {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";

		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YB8C8wwyjhmmfnE6SaNzB99D");

		//File jsonFile = new File("./data/CreateAnIssue.json");

		File jsonSchemaFile = new File("./data/IssueJSONSchema.json");

		Response response = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"RA\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"create issue in RA project iwth variables\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}").post().then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaFile)).extract().response();

		String id = response.jsonPath().getString("id");

		System.out.println(response.asPrettyString());

		deleteAnIssue(id);
	}

	public static void deleteAnIssue(String id) {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";

		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"YB8C8wwyjhmmfnE6SaNzB99D");

		System.out.println("Deleting issue with id: " + id);

		Response response = RestAssured.given().delete(id);

		System.out.println(response.getStatusLine());
	}
}