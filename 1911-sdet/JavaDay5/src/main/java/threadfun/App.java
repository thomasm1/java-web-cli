package threadfun;

public class App {

	/*
	 * The Runnable interface is a functional interface.
	 * Therefore it has only 1 abstract method.
	 */
	public static void main(String[] args) {
		
		Runnable task0 = () -> {
			Resource.change(1, 5000);
		};
		Runnable task1 = () -> {
			Resource.change(2, 5000);
		};
		
		Thread thread0 = new Thread(task0);
		Thread thread1 = new Thread(task1);
		
		
		thread0.start();
		thread1.start();
		
		
		
	}
}
