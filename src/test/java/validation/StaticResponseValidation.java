package validation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseValidation {

	@Test
	public void staticResponse() {
		
		//pre-requisites
	  String expData="TY_PROJ_3631";
	  baseURI = "http://rmgtestingserver";
		port = 8084;
		
		//Action
		Response response = when().get("/projects");
		
		//verification
		response.then().log().all();
		String actData = response.jsonPath().get("[0].projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verified");
		
	}
}
