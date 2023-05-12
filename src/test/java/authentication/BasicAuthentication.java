package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthentication {

	@Test
	public void basicAuthen() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
			.auth()
			.basic("rmgyantra", "rmgy@9999")
			
		.when()
			.get("/login")
			
		.then()
			.log().all()
			.assertThat()
				.statusCode(202)
				;
		
	}
}
