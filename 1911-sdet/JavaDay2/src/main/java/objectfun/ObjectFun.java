package objectfun;

public class ObjectFun {

	public static void main(String[] args) {
		
		Student s1 = new Student("Ryan", 99);
		Student s2 = new Student("Ryan", 99);
		
		System.out.println(s1.toString());
		System.out.println(s1.toString2());
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1 == s2);
		
	}
}
