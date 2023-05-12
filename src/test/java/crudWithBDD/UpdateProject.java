package crudWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class UpdateProject {

	@Test
	public void updateProject() {
		baseURI="http://rmgtestingserver";
		port=8084;

		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Ashwini777");
		jObj.put("projectName", "HrmWithBDD");
		jObj.put("status", "created");
		jObj.put("teamSize", 4);

		//Pre condition
		given()
		    .body(jObj)
		    .contentType(ContentType.JSON)
		
		//Action
		.when()
		.put("/projects/TY_PROJ_5282")
		
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		;
	}
}
