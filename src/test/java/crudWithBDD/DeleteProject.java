package crudWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteProject {

	@Test
	public void deleteProject() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
	 	
		when()
			.delete("/projects/TY_PROJ_5282")
		
		.then()
		.log().all()
			.assertThat()
				.statusCode(204)
				.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
			
		;
	}
}
