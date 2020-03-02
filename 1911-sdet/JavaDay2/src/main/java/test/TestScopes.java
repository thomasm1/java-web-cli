package test;

import encapsulation.Car;

public class TestScopes {

	public static void main(String[] args) {
		
		Car c = new Car("Honda Pilot", 2020);
		c.getModel();
		//c.setModel("Honda Accord");
		System.out.println(c);
		
	}
}
