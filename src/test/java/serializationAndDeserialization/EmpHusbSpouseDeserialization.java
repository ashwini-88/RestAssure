package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.EmpHusband;

public class EmpHusbSpouseDeserialization {

	@Test
	public void deserialization() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omp = new ObjectMapper();
		
		EmpHusband data = omp.readValue(new File("./HusbSpouse.json"), EmpHusband.class);
		
		System.out.println(data.getName());
		System.out.println(data.getMob());
		System.out.println(data.getSpouse().getName());
		
		System.out.println(data.getSpouse().getMob()[0]);
		System.out.println(data.getSpouse().getMob()[1]);
		
	}
}
