package myPractices;

import static io.restassured.RestAssured.basePath;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class POSTPractice {

	@BeforeMethod
	public void setUp() {
	
	RestAssured.baseURI= "https://www.batch8-api-site.dev.cc/wp-json" ;
		basePath= "/wp/v2" ; 
					

}
	@Test
	public void simplePost() {
		
		given()
		.relaxedHTTPSValidation()
		.
		.contentType(ContentType.JSON)
		.when()
		.log().all()
		
		
		
	}
}
