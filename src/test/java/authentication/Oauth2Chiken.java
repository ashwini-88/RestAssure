package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Chiken {

	//redirect_uri: http://hrm_ashwini.com
	//client_secret: e48db7dbe52750a7465ff1607ed2860c
	//client_id: HRM_Ashwini
	//User id : 4513

//	grant_type:  Either client_credentials or authorization_code
//	redirect_uri: (authorization_code only) Must match redirect_uri from the original /authorize call
//	code :(authorization_code only) The authorization code
//base Url: http://coop.apps.symfonycasts.com
	
	String token ;
	
	@Test(priority =1)
	public void getoauth() {
		//create a request to generate access token 
		Response resp = given()
			.formParam("client_id", "HRM_Ashwini")
			.formParam("client_secret", "e48db7dbe52750a7465ff1607ed2860c")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "http://hrm_ashwini.com")
			.formParam("code", "authorization_code")
			
		.when()
			.post("http://coop.apps.symfonycasts.com/token")
			;
		
		//captur the access token from the above request
		token= resp.jsonPath().get("access_token");
		System.out.println(token);
		
		
		
	}
	@Test(priority=2)
	public void get_the_Number_of_Eggs_Collected_Today() {
		
		//create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4513)
		
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		
	.then()
		.log().all()
		.statusCode(200)
		;
	}
	
	@Test(priority = 3)
	public void retrieves_user_that_tied_to_the_access_token() {
		
		given()
		.auth().oauth2(token)
		
	.when()
		.post("http://coop.apps.symfonycasts.com/api/me")
		
	.then()
		.log().all()
		;
	}
	
	@Test(priority = 4)
	public void unlock_the_Barn() {
		//create another request and use the token to access the APIs
				given()
				.auth().oauth2(token)
				.pathParam("USER_ID", 4513)
				
			.when()
				.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
				
			.then()
				.log().all()
				;
	}
	
    @Test(priority = 5)	
	public void put_the_Toilet_Seat_Down() {
    	given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4513)
		
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
		
	.then()
		.log().all()
		;
	}
    
    @Test(priority = 6)	
	public void feed_Your_Chickens() {
    	given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4513)
		
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		
	.then()
		.log().all()
		;
	}
    
    @Test(priority = 7)	
	public void collect_Eggs_from_Your_Chickens() {
    	given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4513)
		
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		
	.then()
		.log().all()
		;
	}
}


