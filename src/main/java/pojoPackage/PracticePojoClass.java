package pojoPackage;

public class PracticePojoClass {
    
	// 1> Declare the Variable Globally
    String name;
    String eID;
    long phNo;
    String email; 
   
    // 4> Provide the getter and the setter mathods 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteID() {
		return eID;
	}

	public void seteID(String eID) {
		this.eID = eID;
	}

	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
   // 2>Create the constructor to initialize the Variables 
    
    public PracticePojoClass(String name, String eID, long phNo, String email) {
		super();
		this.name = name;
		this.eID = eID;
		this.phNo = phNo;
		this.email = email;
	}
	
    //  3> Create the Empty Constructor 
    
    public PracticePojoClass()
    {
    }
    
    
}
