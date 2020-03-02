package welcome;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		int number = 100;
		System.out.println(number);
		number = change(number);
		System.out.println(number);
		
		Car mySUV = new Car();
		mySUV.model = "2015 Honda Pilot";
		System.out.println(mySUV);
		
		mySUV = null;
		System.out.println(mySUV);
	}
	
	//Java is Pass by Value
	public static int change(int num) {
		
		num = 20;
		System.out.println(num);
		return num;
	}
	
	public static void destroy(Car c) {
		
		c = null;
	}
	
}
