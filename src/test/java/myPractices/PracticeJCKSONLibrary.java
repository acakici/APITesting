package myPractices;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

public class PracticeJCKSONLibrary {

	
	@Test
	public void datBinTest() throws Exception {
		
	String jasonString=  "{\"name\" : \"Adam\",\"age\" : 21}" ; 
	System.out.println(jasonString);
	
	ObjectMapper om= new ObjectMapper();

	PersonJACKSONLibrary pl= om.readValue(jasonString, PersonJACKSONLibrary.class);
		System.out.println(pl);
		
		System.out.println(om.writeValueAsString(pl));
		
		PersonJACKSONLibrary p1= JsonPath.from(jasonString).getObject("",PersonJACKSONLibrary.class);
		
		System.out.println(p1);
		

	}	
	@Test
	public void dataBinDateWithCollection() throws Exception {
		
	String jsonStringArr = 
	"[ {\"name\":\"Adam\", \"age\":10} , {\"name\":\"john\", \"age\":12} , {\"name\":\"yuAN\", \"age\":25} ] " ;
		    
		
	PersonJACKSONLibrary[] pesonArr= JsonPath.from(jsonStringArr).getObject("", PersonJACKSONLibrary[].class);
	System.out.println(Arrays.toString(pesonArr));
	
	
	List<PersonJACKSONLibrary> ppl=JsonPath.from(jsonStringArr).getList("",PersonJACKSONLibrary.class );
	System.out.println(ppl);
	
	
	ObjectMapper objMap= new ObjectMapper();
	
	PersonJACKSONLibrary[] pjk= objMap.readValue(jsonStringArr, PersonJACKSONLibrary[].class);
	System.out.println(Arrays.toString(pjk));
	
	
	System.out.println(objMap.writeValueAsString(pjk));
	
	
	}
	
	
	
	

}




