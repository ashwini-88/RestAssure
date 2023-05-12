package parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class FormParameter {

	//Not supported by RMGtestingServer
	
	
	@Test
	public void formParameter() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
			.formParam("createdBy", "Ashu")
			.formParam("projectname", "formParameter")
			.formParam("status", "completed")
			.formParam("teamSize", 4)
			.contentType(ContentType.JSON)
			
			//Action
			.when()
			.post("/addProject")
			
			//validation
		    .then()
		    .log().all()
		    .assertThat()
		    	.statusCode(201)
		    	.contentType(ContentType.JSON)
		    	;
	}
	
}
