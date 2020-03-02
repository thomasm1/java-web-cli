package logging;

public class Playground {

	public static void main(String[] args) {
		
		MyLogger.logger.info("Program Started");
		
		int num;
		MyLogger.logger.warn("The variable 'num' is not used");
		
		
		try {
			int x = 1/0;
		} catch (ArithmeticException e) {
			MyLogger.logger.error(e.getMessage());
		}
		
		MyLogger.logger.info("Program ended");
	}
	
}
