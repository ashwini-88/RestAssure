package postRequest;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import postReqUsingPojo.PojoClassReq;

public class UsingPojoClass {

	@Test
	public void usingPojoClass() {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		PojoClassReq pObj = new PojoClassReq("Monu", "HRM_WithPojoClass", "created", 4);
		
		given()
			.body(pObj)
			.contentType(ContentType.JSON)
		
		
		.when()
			.post("/addProject")
			
			
		.then()
		.log().all()
			.assertThat()
				.statusCode(201)
				.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		;
//		"msg": "Successfully Added",
//	    "createdBy": "Monu",
//	    "projectName": "HRM_WithPojoClass",
//	    "projectId": "TY_PROJ_5459",
//	    "createdOn": "08/05/2023",
//	    "status": "created"
		
	}
	
}
