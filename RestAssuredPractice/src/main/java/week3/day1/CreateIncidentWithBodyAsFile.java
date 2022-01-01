package week3.day1;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class CreateIncidentWithBodyAsFile {

	@DataProvider
	public String[] getData() {
		String[] filepaths = new String[2];
		filepaths[0] = "./data/CreateIncident1.json";
		filepaths[1] = "./data/CreateIncident2.json";

		return filepaths;
	}

	@Test(dataProvider = "getData")
	public void createIncidents(String filePath) {

		File file = new File(filePath);

		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		Response res = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(file).post();

		System.out.println(res.asPrettyString());

	}

}