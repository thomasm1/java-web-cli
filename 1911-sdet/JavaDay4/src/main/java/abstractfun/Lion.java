package abstractfun;

public class Lion extends Animal implements Carnivore {

	@Override
	public void eatMeat() {
		System.out.println("The lion tears into the gazelle with its canines");
	}

	@Override
	public void makeSound() {
		System.out.println("Long live the king");
	}

}
