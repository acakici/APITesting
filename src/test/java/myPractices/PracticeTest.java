package myPractices;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;

public class PracticeTest {

	@BeforeMethod
	public void setUp() {

		RestAssured.baseURI= "https://www.batch8-api-site.dev.cc/wp-json" ;
				basePath= "/wp/v2" ; 
		
	}
	
	@Test
	public void newPost() {
		
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("admin", "admin")
		.when()
		.log().all()
		.contentType(ContentType.JSON)
		.body(" {\r\n" + 
				"		\r\n" + 
				"        \"title\": \"Just a New \",\r\n" + 
				"        \"status\": \"pending\",\r\n" + 
				"        \"slug\" : \"30\"\r\n" + 
				"       \r\n" + 
				"       }")
		
		.post("/posts")
		.then()
		.statusCode(201)
		
		
		;
		
	}
	
	@Test
	public void updatePut() {
		
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("admin", "admin")
		.pathParam("id", 13)
		.when()
		.log().all()
		.contentType(ContentType.JSON)
		.body("  {\r\n" + 
				"		\r\n" + 
				"        \"title\": \"Just a title \",\r\n" + 
				"        \"status\": \"pending\",\r\n" + 
				"        \"slug\" : \"24\"\r\n" + 
				"       \r\n" + 
				"       }")
		
		.put("/posts/{id}")
		.then()
		.statusCode(200)
		.body("title.rendered", is("Just a title"))
		;
		
	}
	
	
	
	
	
	}



