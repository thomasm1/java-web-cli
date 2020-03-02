package db;

import java.util.HashMap;
import java.util.Map;

import model_START_HERE.Pizza;

public class FakeDB {

	/*
	 * This class will eventually be replaced. This will be a way of storing
	 * information for your models. This information will be lost when you terminate
	 * your application. After we learn SQL and JDBC we will replace this with a
	 * connection to a real database to persist your information.
	 * 
	 * When you finish here look at the dao package next.
	 * Look at the PizzaDAO interface first.
	 */

	public static Map<Integer, Pizza> pizzas = new HashMap<Integer, Pizza>();

	// static block is code that executes the very 
	// first time a class is loaded. Therefore this
	// will be pre-populated pizzas. For testing purposes.
	static {
		Pizza p1 = new Pizza("Pepperoni", 1, "Pepperoni/Cheese/Sauce", 10);
		Pizza p2 = new Pizza("Sausage", 2, "Sausage/Cheese/Sauce", 10);
		Pizza p3 = new Pizza("Veggie", 3, "Onions/Green Peppers/Olives/Cheese/Sauce", 8);

		pizzas.put(1, p1);
		pizzas.put(2, p2);
		pizzas.put(3, p3);
	}
}
