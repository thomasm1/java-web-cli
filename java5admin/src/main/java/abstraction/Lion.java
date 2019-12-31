package abstraction;

public class Lion extends Animal implements Carnivore  {

	@Override
	public void eatMeat() {
		// TODO Auto-generated method stub
System.out.println("Tearing into the gazelle ");
	}
	@Override
	public void makeSound() {
		System.out.println("Long Live the King");
		
		
	}
}
