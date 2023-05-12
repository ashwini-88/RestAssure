package reqChaining;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import postReqUsingPojo.PojoClassReq;

public class ReqchainingPrac {

	@Test
	public void reqchainingPrac() {
		
		String projName = "REqChaingPrac"+JavaLibrary.random();
		PojoClassReq pObj = new PojoClassReq("Ashu", projName, "on going", 4);
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		Response resp = given()
		.body(pObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		resp.then().log().all();
		String projId = resp.jsonPath().get("projectId");
		System.out.println(projId);
		
		
		Response resp1 = given().pathParam("pid", projId)
		.when().get("/projects/{pid}");
		
		resp1.then().and().log().all()
		.statusCode(200);
		
		pObj.setStatus("completed");
		
		given()
			.body(pObj)
			.contentType(ContentType.JSON)
			.pathParam("pth", projId)
		.when()
			.put("/projects/{pth}")
		.then()
			.log().status()
			.log().body()
			.assertThat()
				.statusCode(200)
				.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
		
		when()
			.delete("/projects/"+projId)
			
		.then()
			.assertThat()
				.statusCode(204)
				;
			
	}
	
}
