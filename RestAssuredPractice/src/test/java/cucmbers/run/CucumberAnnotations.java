package cucmbers.run;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotations {

	@Before
	public void init() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com",
				"0K2a03CZmogmTYPm6iPUF27F");
		// RestAssured.useRelaxedHTTPSValidation();

	}

	@After
	public void tearDown(Scenario sc) {
		System.out.println(sc.getName() + " : " + sc.getStatus());
	}
}