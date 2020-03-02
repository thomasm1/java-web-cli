package lambdafun;

public class Calculator {

	public static void main(String[] args) {
		
		Calculable add = (x,y) -> {
			System.out.println("Adding two numbers");
			return (x + y);
		};
		
		Calculable multiply = (x,y) -> {
			System.out.println("Multiplying two numbers");
			return (x * y);
		};
		
		
		System.out.println(add.calculate(99, 91));
		System.out.println(multiply.calculate(72, 78));
		
	}
}
