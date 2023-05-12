package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProject {

	@Test
	public void getAllProject() {
		
	//perform Action
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		
	//Provide Validation 
		response.then().log().all();
		int actStatus = response.getStatusCode();
		Assert.assertEquals(200, actStatus);
	}
}
