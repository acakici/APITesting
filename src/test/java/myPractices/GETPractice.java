package myPractices;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.* ;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.* ;




public class GETPractice {

	@BeforeMethod
	public void setUp() {
		
	RestAssured.baseURI= "https://www.batch8-api-site.dev.cc/wp-json" ;	
		basePath = "/wp/v2" ; 
	}
	
	@Test
	public void get() {

		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.get("/posts")
		.then()
		.log().all()
		.assertThat()
//		.body("title.rendered", is("abc")) //does not work if it is uncomment
		.statusCode(200)
		
		;
		
		
		
		
	}
	@Test
	public void getRequest() {
		
	given()
	.relaxedHTTPSValidation()
	.when()
	.log().all()
	.get("/posts")
	.then()
	.assertThat()
	.statusCode(200)
	;
	
	}
	
	@Test
	public void getRequest3() {
		
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.get("/posts")
		.then()
		.assertThat()
		.statusCode(200)
		;
	}
	
	@Test
	public void getRequest4() {
		
	given()
	.relaxedHTTPSValidation()
	.when()
	.log().all()
	.get("/users")
	.then()
	.log().all()
	.assertThat()
	.statusCode(200)
	;
		
	
		
	}
	
	@Test
	public void getRequest5() {
		
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.get("/users")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		;
	}
	
	@Test
	public void getSingleItem() {
		
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.queryParam("per_page", 2)
		.get("/users")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("id", hasItem(1))
		;
	}
	
	@Test
	public void getSingleItem2() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.queryParam("per_page", 1)
		.get("/posts")
		.then()
		.assertThat()
		.statusCode(200)
		.body("id", hasItems(28))
		;
		
		
		
	}
	@Test
	public void printBody() {
		
	given()
	.relaxedHTTPSValidation()
	.contentType(ContentType.JSON)
	.when()
	.log().all()
	.get("/posts")
	.body().prettyPrint()
	
	;

	}
	@Test
	public void simpleGetRequestForSingleItem() {
		
	given()
	.relaxedHTTPSValidation()
	.contentType(ContentType.JSON)
	.when()
	.log().all()
	.pathParam("whatever", 6)
	.get("/users/{whatever}")
	.then()
	.log().all()
	.body("id", equalTo(6))
	.assertThat()
	.statusCode(200)
	;
		
		
	}
}
