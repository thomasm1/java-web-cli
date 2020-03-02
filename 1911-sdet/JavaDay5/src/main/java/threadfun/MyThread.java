package threadfun;

public class MyThread extends Thread{

	//Second way to create a Thread
	@Override
	public void run() {
		System.out.println("Running: " + Thread.currentThread());
	}
	
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		mt1.start();
		mt2.start();
	}
}
