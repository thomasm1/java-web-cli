package garbage;

public class Playground {
	
	public static void main(String[] args) {
		
		Book dracula = new Book("Dracula", 563);
		Book dracula2 = new Book("Dracula", 563);
		Book dracula3 = new Book("Dracula", 563);
		
		dracula = null;
		System.gc();
		
		Book hobbit = new Book("The Hobbit", 350);
		
		hobbit = null;
		
		//It will REQUEST that garbage collection be run.
		System.gc();
		
		Book it = new Book("It", 1000);
		Book it2 = it;
		Book it3 = it2;
		
		it.pages = 1001;
		it = null;
		
		System.gc();
		System.out.println(it);
		System.out.println(it2);
		System.out.println(it3);
		
		
		
		
		System.exit(0);
		
	}

}
