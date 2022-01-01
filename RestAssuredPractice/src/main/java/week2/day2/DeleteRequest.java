package week2.day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {

	@Test
	public void deleteRequest() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		Response response = RestAssured.given().contentType(ContentType.JSON).log().all()
				.delete("93bd29142f600110fa64ad2ef699b623");

		response.then().log().all();

	}
}