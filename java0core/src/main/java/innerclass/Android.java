package innerclass;

public class Android {
	private double cpu = 7;
	private int id = 14;
	
	private class Brain {
		public void think() {
			System.out.println("Android " + id + " has " + cpu + " processing power...\n");
		}
	}
	
	public static class Battery {
		public void charge() {
			System.out.println(" ... Battery charging ...");
		}
	}
	public Android(int id, double cpu) {
		this.id = id;
		this.cpu = cpu;
	}
	public void start() {
		System.out.println("Starting android #" + id);
		Brain brain = new Brain();
		brain.think();
		
		final String name = "Android TMM-KRS";
		
		class Temp {
			public void doChore() {
				System.out.println("ID#" + id + " reporting");
				System.out.println("Greetings, my name is " + name);
				
			}
		}
		Temp temp = new Temp();
		temp.doChore();
	}
}
