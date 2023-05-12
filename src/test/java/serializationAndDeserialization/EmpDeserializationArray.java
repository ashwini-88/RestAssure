package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.EmpPojoArray;

public class EmpDeserializationArray {

	@Test
	public void Deserialization() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omp = new ObjectMapper();
		
		EmpPojoArray data = omp.readValue(new File("./EmpArray.json"),EmpPojoArray.class );
		
		System.out.println(data.getName());
		
		System.out.println(data.getMob()[0]);
		System.out.println(data.getMob()[1]);
	}
}
