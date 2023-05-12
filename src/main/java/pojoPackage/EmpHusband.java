package pojoPackage;

public class EmpHusband {

	String name;
	long mob;
	Spouse spouse;
	
	public Spouse getSpouse() {
		return spouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}


	
	
	public EmpHusband(String name, long mob,Spouse spouse ) {
	
		this.name = name;
		this.mob =mob ;
		this.spouse=spouse;
	}
	
	public EmpHusband()
	{}
}
