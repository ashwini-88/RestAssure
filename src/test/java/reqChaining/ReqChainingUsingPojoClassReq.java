package reqChaining;

import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import postReqUsingPojo.PojoClassReq;

public class ReqChainingUsingPojoClassReq {

	@Test
	public void reqChaining() {
	    
		//projectName Has been appended with the random number 
		String projectName="ReqChaingProj"+JavaLibrary.random();
		
		//create an Object for the Pojo class 
		
		PojoClassReq pObj = new PojoClassReq("Ashwini_DB",projectName,"created",4);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		  Response resp = given()
		.body(pObj)
		.contentType(ContentType.JSON)
		
		.when()
			.post("/addProject");
		  
		//Capture the Proj Id 
		  String projId = resp.jsonPath().get("projectId");
		  System.out.println(projId);
		  resp.then().log().all();
		  
		  
		  //Create a get request and pass projId as PathParemeter 
		 
		Response resp1 = given()
		  	.pathParam("pId", projId)
		  	
		  	.when()
		  	.get("/projects/{pId}");
		  	
		  	String pi = resp1.jsonPath().get("projectId");
	        System.out.println(pi);
	        resp1.then().log().all();
 
	       //Deleting whatever created 
	        given()
		  	.pathParam("pId", projId)
		  	
	        .when()
	        .delete("/projects/{pId}")
	        .then()
	        .log().status()
	        .assertThat()
	        .statusCode(204)
	        ;
		
	}
}
