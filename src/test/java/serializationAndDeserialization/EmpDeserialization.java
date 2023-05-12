package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoPackage.Pojo;

public class EmpDeserialization {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper omp = new ObjectMapper();
		
		 Pojo data = omp.readValue(new File("./emp.json"), Pojo.class);
		
		 System.out.println(data.getMob());
		 System.out.println(data.getName());
		 System.out.println(data.getClass());
	}
}
