package postRequest;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingHashMap {

	@Test
	public void usingHashMap() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		HashMap map = new HashMap();
		map.put("cretedBy", "Monu");
		map.put("projectName", "HrmUsingHashMap");
		map.put("status", "created");
		map.put("teamSize", 4);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
			.post("/addProject")
			
		.then()
		.log().all()
			.assertThat()
				.statusCode(201)
				.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
				;
		
//		 "msg": "Successfully Added",
//		    "createdBy": null,
//		    "projectName": "HrmUsingHashMap",
//		    "projectId": "TY_PROJ_5471",
//		    "createdOn": "08/05/2023",
//		    "status": "created"
			
	}
}
