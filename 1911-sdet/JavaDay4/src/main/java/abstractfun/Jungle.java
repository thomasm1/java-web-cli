package abstractfun;

import java.util.ArrayList;
import java.util.List;

public class Jungle {

	public static void main(String[] args) {
		
		//Cannot make just an Animal
		//Animal a = new Animal();
		
		Lion leo = new Lion();
		
		//Java only knows that this object has methods
		//declared within the Animal class
		//despite that fact that it has other methods
		//as well.
		Animal human = new Human();
		
		System.out.println("===Animal - Human===");
		human.makeSound();
		human.eat();
		
		System.out.println("===Carnivore - Human===");
		Carnivore human2 = new Human();
		
		human2.eatMeat();
		
		System.out.println("===Human - Human===");
		Human human3 = new Human();
		
		human3.makeSound();
		human3.eat();
		human3.eatMeat();
		human3.eatPlant();
		System.out.println(human.species);
		//System.out.println(Human.num);
		
		List<Carnivore> meateaters = new ArrayList<Carnivore>();
		
		meateaters.add(leo);
		//meateaters.add(human);
		meateaters.add(human2);
		meateaters.add(human3);
		
		System.out.println();
		//Enhanced for loop
		//operates on every element of a collection
		for(Carnivore c : meateaters) {
			c.eatMeat();
		}
		
		Bunny b = new Bunny();
		TeddyBear tb = new TeddyBear();
		
		
		List<Petable> cutestuff = new ArrayList<Petable>();
		
		cutestuff.add(b);
		cutestuff.add(tb);
		
		for(Petable p : cutestuff) {
			//Being Petable doesn't add any states
			//or behaviors
			System.out.println(p);
		}
		
	}

}
