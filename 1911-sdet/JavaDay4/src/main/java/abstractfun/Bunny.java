package abstractfun;

public class Bunny extends Animal implements Herbivore, Petable {

	@Override
	public void makeSound() {
		System.out.println("Squeak");
	}
	
	@Override
	public void eatPlant() {
		System.out.println("Eats clover.");
	}

}
