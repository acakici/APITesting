package myPractices;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerializationDeserialization {

	@Test
	public void test() {
		
		String greeting = "{\"name\":\"Adam\" , \"message\":\"Hello\" , \"extraMessage\":\"goodbye\"}" ; 
		
		ObjectMapper op= new ObjectMapper();
		
		Greeting objMap= op.readValue(greeting, Greeting.class);
		
		
}

}
