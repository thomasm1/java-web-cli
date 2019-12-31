package objects;

public class ObjectStudents {

	public static void main(String[] args) {
		
		StudentListMaker s1 = new StudentListMaker("Ryan", 99);
		StudentListMaker s2 = new StudentListMaker("Ryan", 99);
		
		System.out.println(s1.toString());
		System.out.println(s1.toString2());
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1 == s2);
		
	}
}
