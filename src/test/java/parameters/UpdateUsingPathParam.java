package parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateUsingPathParam {

	@Test
	public void updateUsingPathParam() {
		
		//Pre-conditions
				baseURI = "http://rmgtestingserver";
				port = 8084;
				JSONObject jObj = new JSONObject();
				jObj.put("createdBy", "Kumar");
				jObj.put("projectName", "PathParam");
				jObj.put("status", "On Going");
				jObj.put("teamSize", 4);
				
				given()
				.pathParam("pId", "TY_PROJ_3675")
				.body(jObj)
				.contentType(ContentType.JSON)
				
				//Action
				.when()
				.put("/projects/{pId}")
				
				//validation
				.then()
				.log().all()
				.assertThat()
					.statusCode(200)
					.contentType(ContentType.JSON)
					;
			
	}

	
}
