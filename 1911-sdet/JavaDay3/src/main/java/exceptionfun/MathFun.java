package exceptionfun;

import java.util.InputMismatchException;

public class MathFun {

	public static void main(String[] args) {
		
		int x = 5;
		int y = 1;
		
		try {
			
			//System.exit(0);
			
			int result = x/y;
			//Math.addExact(Integer.MAX_VALUE, 1);
			throw new InputMismatchException();
			
		} catch(ArithmeticException e) {
			if(y == 0)
				System.out.println("You divided by 0!");
			e.printStackTrace();
		} catch(InputMismatchException e) {
			e.printStackTrace();
		} finally {
			System.out.println("This code will always execute");
		}
		
	}
}
