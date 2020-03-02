package dao;

import java.util.List;

import model_START_HERE.Pizza;

public interface PizzaDAO {

	/*
	 * A standard practice used in application development
	 * is to code to interfaces. This means create an
	 * interface with all the methods you plan to implement.
	 * Then create a class the implements that interface.
	 * 
	 * You should create an interface and an implementation
	 * for EACH model. This layer of the application is
	 * called the DAO - Data Access Object. And that's
	 * exactly what we are creating: an Object to
	 * access our data.
	 * 
	 * The methods you are looking to create are what are
	 * called the CRUD operations for your model. This
	 * stands for Create, Read, Update, and Delete.
	 * 
	 * Below are some typical methods you might want for
	 * the case of the Pizza model.
	 * 
	 * Once you create this, look to the PizzaDAOImpl file.
	 */

	public boolean createPizza(Pizza p);
	
	public Pizza getPizza(int id);
	
	public List<Pizza> getAllPizzas();
	
	public boolean updatePizza(Pizza change);
	
	public boolean deletePizza(int id);
}
