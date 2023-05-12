package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.PracticePojoClass;

public class PracticePojoClassDeserialization {
 @Test
	public void practicePojoClassSerialization() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omp = new ObjectMapper();
		
		PracticePojoClass practiceData = omp.readValue(new File("./practice.json"), PracticePojoClass.class);
		
		System.out.println(practiceData.getName());
		System.out.println(practiceData.geteID());
		System.out.println(practiceData.getPhNo());
		System.out.println(practiceData.getEmail());
		
	}
 
 @Test
     public  void readingDataFromJsonFileInTheSameClass() throws JsonParseException, JsonMappingException, IOException
     {
	 
	 String jsonData="{\r\n"
	 		+ "  \"name\" : \"Ashwini_DB\",\r\n"
	 		+ "  \"eID\" : \"777_777\",\r\n"
	 		+ "  \"phNo\" : 12345777,\r\n"
	 		+ "  \"email\" : \"ashwini_777@gmail.com\"\r\n"
	 		+ "}";
	 
	 ObjectMapper omp = new ObjectMapper();
	 
	 PracticePojoClass data = omp.readValue(jsonData, PracticePojoClass.class);
	  
	  System.out.println(data.geteID());
	  System.out.println(data.getEmail());
	  System.out.println(data.getName());
	  System.out.println(data.getPhNo());
	  
	 
     }
}
