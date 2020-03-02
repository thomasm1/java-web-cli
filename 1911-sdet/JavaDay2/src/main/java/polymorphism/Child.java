package polymorphism;

public class Child extends Parent {

	String favoritegames;
	
	@Override
	public void work() {
		System.out.println("Im going to start a rock band and tour the world!");
	}
	
	public void play() {
		System.out.println("Playing on the playground");
	}
}
