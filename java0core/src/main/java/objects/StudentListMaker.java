package objects;

public class StudentListMaker {
	
	String name;
	int age;
	
	public StudentListMaker(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj.getClass() != StudentListMaker.class) {
			return false;
		}
		StudentListMaker s = (StudentListMaker) obj;
		
		if (this.name != s.name) {
			return false;
		}
		if(this.age != s.age) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	public String toString2() {
		return "name: " + name + "; age: " + age;
	}
	
	

}
