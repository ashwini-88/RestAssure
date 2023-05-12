package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void queryParameter() {
		
		baseURI="https://reqres.in/";
		
		//pre-Condition
		given()
			.queryParam("page", 2)
		
		//Action
		.when()
			.get("api/users")
			
		//validtaion
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			;
	
	}
}
