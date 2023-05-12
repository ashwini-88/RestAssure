package crudWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProject {

	@Test
	public void createProject() {

		baseURI = "http://rmgtestingserver";
		port = 8084;

		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "AshwiniDB");
		jObj.put("projectName", "HrmWithBDD");
		jObj.put("status", "created");
		jObj.put("teamSize", 4);

		//Pre condition
		given()
		    .body(jObj)
		    .contentType(ContentType.JSON)
		
		//Action 
		    .when()
	       	.post("/addProject")
		
		//Validation
		    .then()
		    .log().all()
		    .assertThat()
		    .statusCode(201)
		    .contentType(ContentType.JSON)
		    .time(Matchers.lessThan(200L),TimeUnit.MILLISECONDS)
		  
		    ;
	}

}
