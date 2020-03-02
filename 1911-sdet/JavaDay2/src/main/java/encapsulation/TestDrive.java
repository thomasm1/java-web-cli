package encapsulation;

public class TestDrive {

	public static void main(String[] args) {
		
		Car c = new Car();
		c.model = "Honda Civic";
		//c.year = 1999;
		c.setYear(99999);
		System.out.println(c.model);
		System.out.println(c.getYear());
	}
}
