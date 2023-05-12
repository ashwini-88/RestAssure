package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void createProject()
	{ 
		JavaLibrary jLib = new JavaLibrary();
		
		//step1:To craete the Pre-requisiteses  -request Body
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Ashwini");
		//jObj.put("projectName", "HrmWithoutBDD"+jLib.random());
		jObj.put("projectName", "HrmWithoutBDD_123456");
		jObj.put("status", "created");
		jObj.put("teamSize",4);
		
		RequestSpecification req = RestAssured.given();
		req.body(jObj);
		req.contentType(ContentType.JSON);
		
		//step2: Perform the Action
		
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
		//step3:validate the response
		
		response.then().log().all().statusCode(201);
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());
		
//
//	    "msg": "Successfully Added",
//	    "createdBy": "Ashwini",
//	    "projectName": "HrmWithoutBDD_1234",
//	    "projectId": "TY_PROJ_5165",
//	    "createdOn": "08/05/2023",
//	    "status": "created"
	}
	
	
}
