package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.EmpPojoArray;

public class EmpSerializationArray {

@Test
public void serialization() throws JsonGenerationException, JsonMappingException, IOException
{
	long[] mobileNo= {1234l,3456l};
	
	EmpPojoArray empPojo = new EmpPojoArray("AshwiniDB",mobileNo);
	
	ObjectMapper omp = new ObjectMapper();
	
	omp.writeValue(new File("./EmpArray.json"), empPojo);
	 
}
}
