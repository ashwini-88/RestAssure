package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.PracticePojoClass;

public class PracticePojoClassSerialization {

	@Test
	public void practicePojoClassSerialization() throws JsonGenerationException, JsonMappingException, IOException {
		
    
	PracticePojoClass practieDetails = new PracticePojoClass("Ashwini","777",12345l,"ashwini@gmail.com");
	
    ObjectMapper omp = new ObjectMapper();
    
  
    
   omp.writeValue(new File("./practice.json"), practieDetails);
    
    String practiceData = omp.writerWithDefaultPrettyPrinter().writeValueAsString(practieDetails);
    
    System.out.println(practiceData);
    
	}
}
