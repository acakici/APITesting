package restAPI.Testing;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAPITesting {

	
	@BeforeClass
	  public void setUp() {
	    
	    RestAssured.baseURI = "https://www.batch8-api-site.dev.cc/wp-json" ;
	    basePath = "/wp/v2" ; 
	    
	  }
	  
	  @Test
	  public void simpleGetRequest() {
	    
	    given()
	      .relaxedHTTPSValidation()
	    .when()
	      .log().all()
	      .queryParam("per_page",2)
	      .get("/posts")
	    .then()
	      .log().all() 
	      .assertThat()
	      .statusCode(200)
	      .and()
	      .body("id", hasItem(28) )
//	      .body("title.rendered", is("Vadym title") )
//	      .body("sticky", is(false))
	      
	      ;
	    
	    // TASK . CHECK YOUR RESPONSE ID AND TITLE IS AS EXPECTED IN YOUR APP
	          
	    
	  }
	  
	  
	  @Test
	  public void printBody() {
	    
	    given()
	      .relaxedHTTPSValidation()
	    .when()
	      .log().all()
	    //.queryParam("per_page",2)
	    .get("/posts")
	      .body().prettyPrint() ; 
	    
	  }
	  
	  @Test
	  public void simpleGetRequestForSingleItem() {
	    
	    given()
	      .relaxedHTTPSValidation()
	    .when()
	      .log().all()
	      //.queryParam("per_page",2)  
	      .pathParam("whatever", 13)
	      .get("/posts/{whatever}") 
	      //.get("/posts/{whatever}" , 24)
	    .then()
	      .log().all() 
	      .assertThat()
	      .statusCode(200)
	      .and()
	      .body("id",  equalTo(13))
//	      .body("title.rendered", is("Vadym title") )
//	      .body("sticky", is(false))
	      
	      ;
	    
	    // TASK . CHECK YOUR RESPONSE ID AND TITLE IS AS EXPECTED IN YOUR APP
	          
	    
	  }
	  
	  @Test
	  public void simplePostTest() {
		 
		  given()
		  .relaxedHTTPSValidation()
		  .auth().preemptive().basic("admin", "admin") //preemptive is
		  .contentType(ContentType.JSON)
		  .when() 
		  .body("{{\r\n" + 
		  		"    \"job_id\": \"AMN_DMP\",\r\n" + 
		  		"    \"job_title\": \"TESTER\",\r\n" + 
		  		"    \"min_salary\": 9200,\r\n" + 
		  		"    \"max_salary\": 19000\r\n" + 
		  		"}}")
		  .log().all()
		  .post("/posts")
		  .then()
		  .log().all()
		  .statusCode(201)
		  ;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	}
