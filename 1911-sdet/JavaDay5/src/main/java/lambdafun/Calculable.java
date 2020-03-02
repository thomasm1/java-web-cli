package lambdafun;

//This is an optional annotation to add.
//prevents compiling if there is another abstract method
//in here
@FunctionalInterface
public interface Calculable {
	
	//This method is designed to take two numbers and
	//give us one in return
	double calculate(double num1, double num2);
	
	
	default void hello() {
		System.out.println("Hello");
	}

}
