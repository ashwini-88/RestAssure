package crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matcher.*;


public class GetAllProject {

	@Test
	public void getAllProject() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
			.get("/projects")
			
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		
		;
	}
}
