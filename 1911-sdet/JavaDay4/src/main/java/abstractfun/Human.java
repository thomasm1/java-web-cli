package abstractfun;

public class Human extends Animal implements Carnivore, Herbivore {

	@Override
	public void eatMeat() {
		System.out.println("Cuts into a steak with a fork and knife");
	}

	@Override
	public void makeSound() {
		System.out.println("Hello World!");
	}
	
	@Override
	public void eatPlant() {
		System.out.println("Makes a salad");
	}

}
