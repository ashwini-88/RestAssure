package pojoPackage;

public class PracticeArray {

	String empName;
	long empId;
	long[] mobNo;
	String eMail;
	
	
	public PracticeArray(String empName, long empId, long[] mobNo, String eMail) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.mobNo = mobNo;
		this.eMail = eMail;
	}
	
	public PracticeArray()
	{}
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long[] getMobNo() {
		return mobNo;
	}

	public void setMobNo(long[] mobNo) {
		this.mobNo = mobNo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteId(String eMail) {
		this.eMail = eMail;
	}
	
}
