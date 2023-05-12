package pojoPackage;

public class Pojo {
 String name;
 long mob;
 
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

 
 public Pojo(String name, long mob) {
	
	this.name = name;
	this.mob = mob;
}
 public Pojo() {}
}
