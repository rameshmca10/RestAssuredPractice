package week5.day1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnStubXMLBody {

	@BeforeMethod
	public void stubSample() {
		stubFor(post("/api/now/table/incident")
				.willReturn(aResponse().withStatus(201).withHeader("content-type", "application/xml")
						.withBody("<result>\r\n" + "<sys_id>32c399111b7001106faa2134604bcba0></sys_id\r\n"
								+ "<category>hardware</category>\r\n" + "<number>INC123999</number>\r\n" + "</root>")));
	}

	@Test
	public void createIncidentWithoutBody() {

//		step1: get Url/ Endpoint
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
//		step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "eTbx92PpzFOZ");
//		
		File file = new File("./data/CreateAnIssue.xml");

		// step3: request type (get) { ctrl+2 , l }
		Response response = RestAssured.given().contentType(ContentType.XML).body(file).post();
//		step4: print response body
		response.prettyPrint();
//		step5: print status code
		System.out.println(response.statusCode());
		System.out.println(response.then().statusCode(201).header("content-Type", "application/xml"));
	}

}