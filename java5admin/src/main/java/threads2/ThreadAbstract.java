package threads2;

public class ThreadAbstract extends Thread {
	public void run() {
		try {
			System.out.println("Thread #" + Thread.currentThread().getId() + " starting");

		} catch (Exception e) {
			System.out.println("exception " + e);
		}
	}
}
