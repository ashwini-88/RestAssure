package crudWithoutBDD;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	@Test
	public void updateProject() {
		//Create the Pre-Requiesit 
		//TY_PROJ_5333
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "AshwiniDB");
		jObj.put("projectName", "HrmWithoutBDD_123456");
		jObj.put("status", "Completed");
		jObj.put("teamSize", 8);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_5333");
		
		response.then().log().all();
		int statusCode=response.statusCode();
		assertEquals(statusCode, 200);
		
	}

}
