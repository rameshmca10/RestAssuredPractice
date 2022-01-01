package week3.day1;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentsWithCookies {

	public static void main(String[] args) {
//		step1: get Url/ Endpoint
		RestAssured.baseURI = "https://dev62655.service-now.com/api/now/table/incident";
//		step2: Authentication (basic)
//		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
		
//		step3: request type (get) { ctrl+2 , l }
//		Response response = RestAssured.given().get();
		Response response = RestAssured.given().cookie("JSESSIONID", "0B46D2E3208DF896B3F2C0B628CE7990").get();
		
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());

		Map<String, String> AllCookies = response.getCookies();
		// for(datatype temp : collection_object)
		for (Entry<String, String> eachEntry : AllCookies.entrySet()) {
			System.out.println(eachEntry.getKey() + " : " + eachEntry.getValue());
		}

	}

}