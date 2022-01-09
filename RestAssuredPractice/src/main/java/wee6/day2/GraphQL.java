package wee6.day2;

import java.io.File;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class GraphQL {

	static String jsonBody = "{\r\n"
			+ "  viewer {\r\n"
			+ "    login\r\n"
			+ "  }\r\n"
			+ "  repository(name: \"Leaftaps\", owner: \"SarathTL\") {\r\n"
			+ "    createdAt\r\n"
			+ "    id\r\n"
			+ "    owner {\r\n"
			+ "      id\r\n"
			+ "      avatarUrl\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "}";

	public static void main(String[] args) {
		// TODO Auto-generated method stubpublic void createIncidents(String filePath) {

		RestAssured.baseURI = "https://api.github.com/graphql";

		Response res = RestAssured.given()
				.header(new Header("Authorization", "Bearer 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")).log().all()
				.contentType(ContentType.JSON).body(convertJsonToString(jsonBody)).post();

		System.out.println(res.asPrettyString());

	}

	private static String convertJsonToString(String str) {

		JSONObject obj = new JSONObject();

		obj.put("query", str);

		return obj.toString();

	}

}