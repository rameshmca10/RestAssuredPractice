package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends BaseAPI {

//	@Test(dependsOnMethods = {"pathmethod1","pathmethod2"})
	// packageName.ClassName.MethodName
	@Test(dependsOnMethods = "week3.day1.UpdateIncidentWithoutBody.updateIncidentWithoutBody")
	public void deleteIncident() {
//		step1: get Url/Endpoint
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
//		step3: request type (delete) { ctrl+2 , l }
		Response response = RestAssured.given().pathParam("sysID", sysID).delete("{sysID}");
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());

	}

}