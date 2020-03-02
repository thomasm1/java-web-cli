package polymorphism;

public class Calculator {

	public static void main(String[] args) {
		
		System.out.println(add(5,10));
		System.out.println(add(5d,10d));
		//5.0 5.0d 5.d 5d
		System.out.println(add(5,10,20));
		System.out.println(add());
		System.out.println(add("3","4"));
		System.out.println(add("3",4));
		System.out.println(add(3,"4"));
		//System.out.println(add("Three","Four"));
		
	}
	/*
	 * Overloading is when you have methods with the same
	 * name but different number or order of parameters.
	 * Unique combination of parameters.
	 */
	
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public static double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public static int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	public static int add() {
		return 0;
	}
	
	public static int add(String num1, String num2) {
		
		//return num1 + num2; This is concatenation
		
		return Integer.parseInt(num1) + Integer.parseInt(num2);
	}
	
	public static int add(String num1, int num2) {
		return Integer.parseInt(num1) + num2;
	}
	
	public static int add(int num1, String num2) {
		return num1 + Integer.parseInt(num2);
	}
}
