package myPractices;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.sql.Driver;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPath_Practice2 {

	
	@BeforeMethod
	public void init() {
	
	RestAssured.baseURI= "https://www.batch8-api-site.dev.cc" ; 
	RestAssured.basePath= "/wp-json/wp/v2" ; 
	RestAssured.useRelaxedHTTPSValidation();
	
	}
	
	@Test
	
	public void justSiplyGetRequest() {
		
	Response response= 
			given().when().log().all()
			.get("/posts")
		;
	
	JsonPath jasonPath= response.jsonPath();
	System.out.println(jasonPath.getInt("author[0]"));
	
	//Print all authors
	List<Object> authInt= jasonPath.getList("author");
	
	List<Integer> lstInt= jasonPath.getList("author", Integer.class);
	System.out.println(lstInt);
	
	List<String> lstStr= jasonPath.getList("title.rendered", String.class);
	System.out.println(lstStr);
	
	
	}
	@Test
	public void getAllDriverFirstname() {
		
	Response response=
		given()
		.when()
		.get("http://ergast.com/api/f1/drivers.json")
		;
	JsonPath jp = response.jsonPath();
	List<String> lstGivenName = jp.getList("MRData.DriverTable.Drivers.givenName", String.class);
	
	System.out.println( lstGivenName);
	
	//System.out.println(jp.get("MRData.DriverTable.Drivers[0]") );
	
	Map map1 = jp.getMap("MRData.DriverTable.Drivers[0]") ; 
	System.out.println(map1);
	System.out.println(map1.keySet());
	
	Map<String, String> map2 = jp.getMap("MRData.DriverTable.Drivers[0]",String.class, String.class) ;  
	System.out.println( map2.values() );
	
	System.out.println( jp.getString("MRData.DriverTable.Drivers[1].givenName" )) ; 
	
	// JSONPATH That rest assured use is the GPath from groovy 
	// Predicate 
	System.out.println(jp.getList("MRData.DriverTable.Drivers.findAll{ it.givenName=='George'}") ); 
		
		List<Object> lstObj= jp.getList("MRData.DriverTable.Drivers.findAll{it.givinName.length()==3}");
		System.out.println(lstObj);
		
		Driver driverObj= jp.getObject("MRData.DriverTable.Drivers[1]", Driver.class);
		System.out.println(driverObj);
		
	}
	
	
}
