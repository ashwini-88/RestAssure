package crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSingleProject {

//	"projectId": "TY_PROJ_5204",
//    "projectName": "HrmWithBDD",
//    "teamSize": 4,
//    "createdBy": "AshwiniDB",
//    "createdOn": "08/05/2023",
//    "status": "created"
	@Test
	public void getSingleProject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.get("/projects/TY_PROJ_5282")
		
		
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		
	    ;
	}
	
}
