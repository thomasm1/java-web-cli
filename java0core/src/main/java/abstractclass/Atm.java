package abstractclass;

public class Atm extends Machine {

	@Override
	public void start() {
		System.out.println("ATM Starting up Gears");
	}
	
	@Override
	public void functionNow() {
		System.out.println("Processing In Motion");
	}
	
	@Override
	public void stop() {
		System.out.println("ATM Stopping Gears");
	}
}
