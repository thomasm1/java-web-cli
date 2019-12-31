package abstractclass;

public class AbstractClassApp {

	public static void main(String[] args) {
		Atm atm1 = new Atm();
		atm1.setId(5);
		atm1.run();
		System.out.println("\n --------------------");
		Bicycle bike1 = new Bicycle(); 
		bike1.setId(bike1.getId());
		bike1.run();

	}

}
