package crudWithoutBDD;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {

	@Test
	public void deleteProject() {
		
		//Perform Action
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_5998");
		
		//validation 
		response.then().log().all();
		int actStatus = response.getStatusCode();
		Assert.assertEquals(actStatus, 204);
	}
}
