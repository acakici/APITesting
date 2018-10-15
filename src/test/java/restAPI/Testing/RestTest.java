package restAPI.Testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class RestTest {

	
	@BeforeClass
	public void setUp() {
		
		RestAssured.baseURI = "https://www.batch8.api.site.dev.cc/wp-json";
		RestAssured.basePath = "/wp/v2"; 	
	}
	
		// Given rest end point http://73.166.37.2:1000/ords/hr/employees/100
        // When I send HTTP Get request to the server
        // Then I should get 200 OK result as status code
	
	@Test
	public void firstTest() {
		
	when()
		.get("http://73.166.37.2:1000/ords/hr/employees/100")
		.then()
		.statusCode(200);
		
	}
	@Test
	public void secondTest() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.get("https://www.batch8.api.site.dev.cc/wp-json/wp/v2/posts")
		.then()
		.statusCode(200);
	}
	
	
	@Test
	public void idTest() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.get("https://www.batch8.api.site.dev.cc/wp-json/wp/v2/posts/13")
		.then()
		.statusCode(200)
		.and()
		.body("id", equalTo(13))
		.body("title.rendered", equalTo("I got it"));
	}
	
	@Test
	public void idTest_withLogDetailTest() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.get("https://www.batch8.api.site.dev.cc/wp-json/wp/v2/posts/13")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("id", equalTo(13))
		.body("title.rendered", equalTo("I got it"));
		

	}
	@Test
	public void idPassParameterTest() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.get("https://www.batch8.api.site.dev.cc/wp-json/wp/v2/posts/{id}",13)
		
		.then()
		.statusCode(200)
		.and()
		.body("id", equalTo(13))
		.body("title.rendered", equalTo("I got it"))
		.body("status", equalTo("publish"))
		;
	}
	
	
		@Test
		public void Four_Test(){
			

			given()
				.relaxedHTTPSValidation()	
			.when()
				.get("/posts")
			.then()
				.statusCode(200) ; 
			
		}
		@Test
		public void testWithHamcrest() {
		
			int a =5, b= 5, c=6;
			
			assertTrue(a==b);
			assertEquals(a,b);
			
//			assertThat(a, equalTo(b));
			
		}

			
		}





