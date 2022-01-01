package step.def;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StepDefIssueManagement {

	private Response response;

	@Given("set the endpoint")
	public void inItEndpoint() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
	}

	@And("set up the basic auth with valid credential")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"0K2a03CZmogmTYPm6iPUF27F");
	}

	@When("send the post request with body as file {string}")
	public void createIncident(String str) {
		File file = new File(str);
		response = RestAssured.given().contentType(ContentType.JSON).body(file).post();
	}

	@When("send the post request with body as {string}")
	public void createIncidentWithBody(String jsonFile) {
		File file = new File(jsonFile);
		response = RestAssured.given().contentType(ContentType.JSON).body(file).post();

	}

//	@And("verify the status code as (.*)$")
	@And("verify the status code is {int}")
	public void verfystatusCode(int code) {
		response.then().statusCode(code).extract().response();
	}

	@And("verify the response body contains contentType is (.*)$")
	public void verfycontentType(String type) {
		if (type.toLowerCase().contains("json")) {
			response.then().contentType(ContentType.JSON).extract().response();
		} else if (type.toLowerCase().contains("xml")) {
			response.then().contentType(ContentType.XML).extract().response();
		} else {
			throw new RuntimeException("ContentType not matching");
		}
		response.prettyPrint();
	}
}