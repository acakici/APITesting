package myPractices;

import static io.restassured.RestAssured.basePath;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class AutoPost {

	Faker f= new Faker();
	int newUserId;
	int newId;
	
	@BeforeClass
	public void setUp() {

		RestAssured.baseURI= "https://www.batch8-api-site.dev.cc/wp-json" ;
				basePath= "/wp/v2" ; 
				newId=autoPost();
		
	}
	
	@Test
	public void userEdit() {
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("admin", "admin")
		.pathParam("id", newId)
		.when().log().all()
		.contentType(ContentType.JSON)
		.body("\r\n" + 
				"    {\r\n" + 
				"       \r\n" + 
				"        \"first_name\" : \"hasan\",\r\n" + 
				"         \"last_name\": \"gul\"\r\n" + 
				"        \r\n" + 
				"       }")
		
		.put("/users/{id}")
		.then()
		.log().all()
		.statusCode(200)
		.body("first_name", is("hasan"))
		
		;
		
	}
	
	
	public int autoPost() {
		
		Response response = given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("admin", "admin")
		.when()
		.log().all()
		.contentType(ContentType.JSON)
		.body("\r\n" + 
				"    {\r\n" + 
				"		\r\n" + 
				"        \"username\": \""+f.name().firstName()+"\",\r\n" + 
				"        \"name\": \"hak\",\r\n" + 
				"        \"first_name\" : \"hakim\",\r\n" + 
				"         \"last_name\": \"ci jitere\",\r\n" + 
				"          \"email\": \""+f.internet().emailAddress()+"\"\r\n" + 
				"       }")
		
		.post("/users")
		
		;
		newUserId=response.jsonPath().get("id");
		
		return newUserId;
		
		
		 
		
	}
	
	
	
}

	
	
	
