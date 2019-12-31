package threads2;

public class ThreadInterface implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Threads " + Thread.currentThread().getId() + " starting");
		} catch (Exception e) {
			System.out.println("exception " + e);
		}
	}
}
