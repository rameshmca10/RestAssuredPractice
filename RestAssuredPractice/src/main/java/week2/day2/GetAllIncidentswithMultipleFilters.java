package week2.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllIncidentswithMultipleFilters {

	@Test
	public void getAllIncidents() {
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("sysparm_fields", "sys_id, category, number");
		queryParams.put("category", "software");

		Response response = RestAssured.given().queryParams(queryParams).accept(ContentType.JSON).get();

		List<String> list = response.jsonPath().getList("result.sys_id");
		System.out.println(list);

		System.out.println(response.getStatusLine());

	}

}