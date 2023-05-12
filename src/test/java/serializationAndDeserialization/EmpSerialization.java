package serializationAndDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoPackage.Pojo;

public class EmpSerialization {
@Test
	public static void main(String[] args) throws Throwable {
		Pojo pojo = new Pojo("Ashwini", 45454);

		ObjectMapper omp = new ObjectMapper();
		
		omp.writeValue(new File("./emp.json"), pojo);
		
		
		
	}
}