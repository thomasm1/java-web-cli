package polymorphism;

public class Playground {

	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.work();
		//p.play();	this only exists in the Child.
		
		Child c = new Child();
		c.play();
		c.work(); //Overridden method.
		
		Parent pc = new Child();
		pc.work();
		
		Child c2 = (Child) pc;
		//Child c3 = (Child) p;
		
		Parent p2 = (Parent) pc;
		p2.work();
		
		
		/*
		 * The rules for overriding
		 * The method signature has to be exactly the same
		 * in the parent class and child class.
		 * 
		 * Types of polymorphism:
		 * 
		 * Overloading
		 * Overriding
		 * Casting
		 */
		
	}
}
