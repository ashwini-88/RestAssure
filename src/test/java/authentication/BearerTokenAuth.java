package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenAuth {

	String RepoName="RestAssured";
	String bearerToken="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";
	
	@Test(priority = 1)
	public void bearerTokenAuth() {
		
		baseURI="https://api.github.com";
		
		JSONObject jObj=new JSONObject();
		jObj.put("name", RepoName);
		
		given()
			.auth()
			.oauth2(bearerToken)
			.body(jObj)
			.contentType(ContentType.JSON)
	
//		given()
//			.auth()
//			.oauth2("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")
//			.body(jObj)
//			.contentType(ContentType.JSON)

		.when()
			.post("/user/repos")
			
		.then()
			.log().all()
			.assertThat()
				.statusCode(201)
		;
	}
	@Test(priority = 2,dependsOnMethods = "bearerTokenAuth")
	public void deleteRepo() {
		given()
			.pathParam("owner", "ashwini-88")
			.pathParam("repo", RepoName)
			.auth()
			.oauth2(bearerToken)
		
		
		.when()
			.delete("/repos/{owner}/{repo}")
			
		.then()
			.log().all()
			.assertThat()
				.statusCode(204)
				;
		
		
	}
}
