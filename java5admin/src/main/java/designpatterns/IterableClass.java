package designpatterns;
import java.util.Iterator;
import java.util.LinkedList;

public class IterableClass {
	public static void main(String[] args) {
		
		LinkedList<String> coins = new LinkedList<String>();
		
		coins.add("btc");
		coins.add("eth");
		coins.add("ltc");
		coins.add("xrp");
		
		// Pre Java 5
		Iterator<String> it = coins.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);
			
			if (value.equals("xrp")) {
			it.remove();
			}
		}
		 System.out.println("===========");
		
		// Post Java 5
		for(String coin: coins) {
			System.out.println(coin); 
			// coins.remove(2); 
			// can't remove.. Would mean concurrent modification error 
			//(altering list while iterating through it)
		}
		 System.out.println("---xrp removed...------");
		
		
	}
}

