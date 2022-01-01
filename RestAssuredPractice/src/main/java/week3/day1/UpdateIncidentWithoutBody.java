package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncidentWithoutBody extends BaseAPI {

	@Test(dependsOnMethods = "week3.day1.CreateIncidentWithoutBody.createIncidentWithoutBody")
	public void updateIncidentWithoutBody() {
//		step1: get Url/Endpoint
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
//		step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.given().contentType(ContentType.JSON).put(sysID).then().statusCode(200)
				.extract().response();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}

}