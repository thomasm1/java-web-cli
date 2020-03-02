package stringfun;

public class Sandbox {

	public static void main(String[] args) {
		
		Integer i1 = 10;
		Integer i2 = 10;
		
		//Whenever you call == with primitives it check value
		System.out.println(4 == 4);
		System.out.println(i1 == i2);
		//Whenever you call == with objects it checks memory addresses
		
		String hello1 = "Hello";
		String hello2 = "Hello";
		
		System.out.println(hello1 == hello2);
		
		String hello3 = new String("Hello");
		
		System.out.println(hello1 == hello3);
		
		//reassigning the variable creates a whole new string
		hello1 = "Hey";
		
		StringBuilder sb = new StringBuilder("Hello Everyone");
		
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		long timestart = System.currentTimeMillis();
		
		StringBuilder a = new StringBuilder("a");
		for(int i = 0; i < 1000000; i++) {
			a.append("a");
		}
		
		long timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);

		
		timestart = System.currentTimeMillis();
		String a2 = new String("a");
		for(int i = 0; i < 1000000; i++) {
			a2.concat("a");
		}
		timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
		
		StringBuffer sbuff = new StringBuffer("Hey");
		
		timestart = System.currentTimeMillis();
		StringBuffer a3 = new StringBuffer("a");
		for(int i = 0; i < 1000000; i++) {
			a3.append("a");
		}
		timeend = System.currentTimeMillis();
		System.out.println(timeend - timestart);
	}

}
