package wrapper;

public class Wrapper {

	public static void main(String[] args) {
		
		double d;	//primitive version
		Double dd = 0.0;
		Double ddd = new Double(3);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(dd.MAX_VALUE);
		
		Byte bb;
		Integer ii;
		Character cc;
		Short ss;
		Long ll;
		Boolean bool;
		Double dddd;
		Float ff;
		
		
		int n1 = 9;
		int n2 = 10;
		add(n1,n2);
		
		//The value within the Object is unboxed: unboxing
		Integer n3 = 14;
		Integer n4 = 15;
		add(n3,n4);
		
		//The primitive turns into an Object: autoboxing
		int n5 = 8;
		int n6 = 21000000;
		
		try {
			System.out.println(Math.multiplyExact(n5, n6));
		} catch(ArithmeticException e) {
			System.out.println("Multiplication is too large!!!");
		}
		
	}
	
	public static void add(int num1, int num2) {
		System.out.println(num1 + num2);
	}
	
	public static void multiply(Integer num1, Integer num2) {
		System.out.println(num1 * num2);
	}
}
