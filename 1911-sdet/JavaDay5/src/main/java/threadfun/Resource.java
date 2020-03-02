package threadfun;

public class Resource {

	static Integer number = 0;
	
	public synchronized static void change(int num, int delay) {
		
		try {
			System.out.println(Thread.currentThread());
			Thread.sleep(delay); //simulating the code that
								//takes some time to do something
			number = num;
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
