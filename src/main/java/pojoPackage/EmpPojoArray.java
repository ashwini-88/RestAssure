package pojoPackage;

public class EmpPojoArray {

	String name;
	long[] mob;
	
	public String getName() {
		return name;
	}

	public long[] getMob() {
		return mob;
	}

	
	public EmpPojoArray(String name, long[] mob) {
		
		this.name = name;
		this.mob = mob;
	}
	
	public EmpPojoArray()
	{
		
	}
	
}
