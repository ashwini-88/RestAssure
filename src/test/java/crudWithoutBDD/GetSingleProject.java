package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetSingleProject {

	@Test
	public void getSingleProject() {
		
		//perform Action
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_5998");
		
		//Provide Validation 
		response.then().log().all();
		int actStatus = response.getStatusCode();
		Assert.assertEquals(200, actStatus);
	}
}
