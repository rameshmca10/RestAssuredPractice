package cucumber.run;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotation {

	@Before
	public void inIt() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
	}

	@After
	public void tearDown(Scenario sc) {
		System.out.println(sc.getName() + " : " + sc.getStatus());
	}
}