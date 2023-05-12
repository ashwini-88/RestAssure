package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.PracticeArray;

public class PracticeArraySerialization {

	@Test
	public void practiceArraySerialization() throws JsonGenerationException, JsonMappingException, IOException {
		
		long[] mobileNos= {98765l,95432l};
		PracticeArray practiceArray = new PracticeArray("Ashwini",1234,mobileNos,"ashu@gmail.com") ;
		
		ObjectMapper omp = new ObjectMapper();
		
       omp.writeValue(new File("./PracticeArray.json"), practiceArray);
	}
}
