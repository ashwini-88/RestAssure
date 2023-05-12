package parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeletePathParam {

	@Test
	public void deletePathParam() {
		//Pre-conditions
				baseURI = "http://rmgtestingserver";
				port = 8084;
				
				given()
				 	.pathParam("pId", "TY_PROJ_3675")
				
		        .when()
		        	.delete("/projects/{pId}")
		        	
		      //validation
		        .then()
		        .log().all()
		        .assertThat()
		        	.statusCode(204)
		        	;
				
	}
	
}
