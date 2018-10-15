package myPractices;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import restAPI.Testing.Person;

public class PracticeJAKSONLibrary2 {

	
	
	@Test
	public void dataBinTest() throws Exception {
		
		String jsonString = "{\"name\" : \"Adam\",\"age\" : 21}" ; 
		
		ObjectMapper om= new ObjectMapper();
		
		PersonJACKSONLibrary prjl=	om.readValue(jsonString, PersonJACKSONLibrary.class);
		
		System.out.println(jsonString);
		
		String convertedStr= om.writeValueAsString(prjl);
		
		System.out.println(convertedStr);
		
	
	}
	
	

	
	
}
