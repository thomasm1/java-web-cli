package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import db.FakeDB;
import model_START_HERE.Pizza;

public class PizzaDAOImpl implements PizzaDAO {

	/*
	 * Now we must implement these methods.
	 * The benefit to coding to an interface means that
	 * when we replace these implementations with
	 * real database accesses, then are can just swap
	 * out which implementation we use.
	 * 
	 * Our methods will call to our fake DB.
	 * 
	 * After this, you should have a working model. The
	 * only problem is that methods in an interface
	 * cannot be static, which means that these methods
	 * can only used if you instantiate a PizzaDAOImpl
	 * Object. I like to make a service package (layer)
	 * for my application that instantiates the PizzaDAOImpl
	 * Object and will make a static version of each method.
	 * Each method looks exactly the same only adding the
	 * static keyword to the method signature. The
	 * implementation is to simply call/return the 
	 * corresponding method you see below.
	 */
	public boolean createPizza(Pizza p) {
		FakeDB.pizzas.put(p.getId(), p);
		//returning true just means success.
		return true;
	}

	public Pizza getPizza(int id) {
		return FakeDB.pizzas.get(id);
	}

	public List<Pizza> getAllPizzas() {
		//This one is tricky because we have a Map.
		//This wont be complicated when we convert to
		//using real databases.
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		Set<Integer> keys = FakeDB.pizzas.keySet();
		for(Integer k : keys)
			pizzaList.add(FakeDB.pizzas.get(k));
		
		return pizzaList;
	}

	public boolean updatePizza(Pizza change) {
		//We are going to assume you aren't changing
		//id of the pizza, just its info.
		
		FakeDB.pizzas.replace(change.getId(), change);
		return true;
	}

	public boolean deletePizza(int id) {
		FakeDB.pizzas.remove(id);
		return true;
	}

}
