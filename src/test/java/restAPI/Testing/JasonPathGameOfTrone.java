package restAPI.Testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JasonPathGameOfTrone {

	Faker faker = new Faker();
	int newUserID;

	// @BeforeMethod
	// public void init() {
	//
	// RestAssured.baseURI = "https://api.got.show/api/characters/";
	// RestAssured.basePath = "/wp-json/wp/v2";
	// RestAssured.useRelaxedHTTPSValidation();

	// }

	@Test
	public void testJsonPath() {

		Response response =

				given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.when()
				.log().all()
				.get("https://api.got.show/api/characters/")

		;
		JsonPath jp = response.jsonPath();

	//	List<String> lst = jp.getList("house");

		
		
		Map<String, String> lstString = jp.getMap("house", String.class, String.class);
		System.out.println(lstString.values());

		
		
		
		
	}
}
