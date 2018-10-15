package myPractices;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.RestAssured;

public class AutoPostPr {

	@BeforeClass
	public void setUp() {

	RestAssured.baseURI="http://";
	
	
	}
	@Test
	public void get() {
	
	given()
	.relaxedHTTPValidation()
	.when()
	.get("/posts")
	.
		
		
	}
	
	
	

}
