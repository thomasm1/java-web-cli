package constructors;

public class ConstructionZone {

	public static void main(String[] args) {
		
//		Dwelling d = new Dwelling();
//		Dwelling d2 = new Dwelling(1200);
//		
//		System.out.println(d);
//		System.out.println(d2);
		
		House h = new House(6);
		House h2 = new House(8, 9001);
		
		System.out.println(h);
		System.out.println(h2);

	}

}
