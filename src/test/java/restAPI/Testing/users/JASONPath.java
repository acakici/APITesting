package restAPI.Testing.users;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class JASONPath {

	
	@BeforeClass
	public void init() {
		
		RestAssured.baseURI = "https://www.batch8.api.site.dev.cc";
		RestAssured.basePath = "/wp-json/wp/v2";

		
	}
	
	
	
	
}
