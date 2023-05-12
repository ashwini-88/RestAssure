package postRequest;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Json_Object {

	@Test
	public void json_Object() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;

		JSONObject jObj = new JSONObject();
		jObj.put("cretedBy", "Monu");
		jObj.put("projectName", "HrmUsingJsonObject");
		jObj.put("status", "created");
		jObj.put("teamSize", 4);
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
			.post("/addProject")
			
		.then()
		.log().all()
			.assertThat()
				.statusCode(201)
				.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
				;
			
	}
}
