package abstractfun;

public interface Herbivore {
	
	//All interfaces can have variables BUT they must
	//all be public static final.
	//EVEN if is it not explicitly stated.
	int num = 100;
	
	
	//Since Java 8 you can use the default keyword
	//to define an implementation
	
	public default void eatPlant() {
		System.out.println("Eats plant. Yum.");
	}

}
