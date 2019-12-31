package threads2;

public class ThreadAbstractMain  {
	public static void main(String[] args) {
		int n = 8; // # of threads
		for (int i=0; i < n; i++) {
			ThreadAbstract obj = new ThreadAbstract();
			obj.start();
		}
	}
}
 