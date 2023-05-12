package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.EmpHusband;
import pojoPackage.Spouse;

public class EmpHusbSpouseSerialization {

	@Test
	public void serializationEmpHusbSpouse() throws JsonGenerationException, JsonMappingException, IOException
	{
		long[] mobileNo= {1234,9876};
		Spouse sp = new Spouse("Ashwini",mobileNo);
		
		EmpHusband hus = new EmpHusband("Chetan",4567, sp);
		
		ObjectMapper omp = new ObjectMapper();

        omp.writeValue(new File("./HusbSpouse.json"), hus);
        
        String print = omp.writerWithDefaultPrettyPrinter().writeValueAsString(hus);
		
        System.out.println(print);
	}
}
