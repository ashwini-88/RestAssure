package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {

	@Test
	public void dynamicResponse() {
		// Pre-requisites
		String expData = "TY_PROJ_3631";
		baseURI = "http://rmgtestingserver";
		port = 8084;

		// Action
		Response response = when().get("/projects");

		// validation
		boolean flag = false;
		List<String> pIds = response.jsonPath().get("projectId");
		for (String ProjId : pIds) {

			if (ProjId.equalsIgnoreCase(expData)) {
				flag = true;
			}
		}

		response.then().log().all();
		assertEquals(flag, true);
		//assertTrue(flag);
		System.out.println("data verified");

	}

}
