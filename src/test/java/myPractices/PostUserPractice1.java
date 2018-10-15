package myPractices;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostUserPractice1 {

	@BeforeMethod
	public void setUp() {
		
	RestAssured.baseURI= "https://www.batch8-api-site.dev.cc/wp-json" ;	
		basePath = "/wp/v2" ; 
	}
	@Test
	public void postUser() {
	
	//	String url="http://www.batch8-api-site.dev.cc/wp-json/wp/v2/users/";
		
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.get("/users/1")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
		
	}
	
	@Test
	public void postPractice() {
		
	Map<String, String> map= new HashMap<>();
	map.put("username", "mgunduz");
    map.put("firstName", "mehmet");
    map.put("lastName", "G");
    map.put("email", "mehmet@gmail.com");
    map.put("password", "12345");
    map.put("role", "Editor");
    
   Response response =given()
    .relaxedHTTPSValidation()
    .auth()
    .preemptive()
    .basic("admin", "admin")
    .accept(ContentType.JSON)
    .contentType(ContentType.JSON)
    .body(map)
    .post("/users");
    
    assertEquals(response.statusCode(), 201);
    
    
    
    
	
		
		
	}
	
	
	
}
