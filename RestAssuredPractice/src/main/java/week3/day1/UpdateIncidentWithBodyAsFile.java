package week3.day1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public final class UpdateIncidentWithBodyAsFile {

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

		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident/993b34342f200110fa64ad2ef699b6f3";
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");

		Map<String, String> map = new HashMap<String, String>();

		map.put("Content-Type", "application/json");
		map.put("Accept", "application/xml");

		Response res = RestAssured.given().headers(map).body(file).put();

		System.out.println(res.getStatusLine());

		System.out.println(res.asPrettyString());

	}

}