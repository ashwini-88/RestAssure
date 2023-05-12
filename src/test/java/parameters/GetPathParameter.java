package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetPathParameter {

	@Test
	public void pathParameter() {
		
		//Pre-conditions
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
		.pathParam("pId", "TY_PROJ_3631")
		
		//Action
		.when()
		.get("/projects/{pId}")
		
		
		//Validation
		
		.then()
		.log().all()
		.assertThat()
			.statusCode(200)
		;
		
		
		
	
	}
}
