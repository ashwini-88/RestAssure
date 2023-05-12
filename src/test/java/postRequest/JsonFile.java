package postRequest;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class JsonFile {

	@Test
	public void jsonFile() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		File file = new File("C:\\Users\\91917\\Documents\\RestAssure\\src\\test\\resources\\JsonFileRqr.json");
		//File file = new File("C:\\Users\\91917\\Documents\\RestAssure\\PostRequest.json");
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
		
		
		.when()
			.post("/addProject")
		
		
		.then()
		.log().all()
			.assertThat()
				.statusCode(201)
				.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		;
		// "msg": "Successfully Added",
//	    "createdBy": "AshwiniDB",
//	    "projectName": "HrmUsingJsonFile",
//	    "projectId": "TY_PROJ_5452",
//	    "createdOn": "08/05/2023",
	}
}
