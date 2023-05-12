package dataProvider;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import postReqUsingPojo.PojoClassReq;


public class CreateMultipleProjectUsing_DataProvider {

 
	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[2][4];
		
		obj[0][0]="abc";
		obj[0][1]="abc"+JavaLibrary.random();
		obj[0][2]="created";
		obj[0][3]=4;
		
		obj[1][0]="def";
		obj[1][1]="abc"+JavaLibrary.random();
		obj[1][2]="completed";
		obj[1][3]=6;
		
		return obj;
		}
	
	@Test(dataProvider ="data" )
	
	public void createProject(String createdBy,String projectName,String status,int size) {
		
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		
		PojoClassReq pobj = new PojoClassReq(createdBy, projectName, status, size);
		
		//PreCondition
	
		given()
			.body(pobj)
			.contentType(ContentType.JSON)
			 
		//Action
		.when()
		.post("/addProject")
		
		//validation
		.then()
		.log().all()
		.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
			;
			
	}
}
