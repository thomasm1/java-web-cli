package service;

import dao.PizzaDAO;
import dao.PizzaDAOImpl;
import model_START_HERE.Pizza;

public class PizzaService {

	/*
	 * This class to simply here to make my DAO
	 * methods static. It can also be a place
	 * to add additional methods with more business logic
	 * that utilize the DAO methods you have.
	 */
	
	/*
	 * Here is where we can interchange implementations
	 * of our DAO methods. All I have to do is
	 * instantiate pd to a different Implementation
	 * as needed.
	 */
	public static PizzaDAO pd = new PizzaDAOImpl();
	
	/*
	 * This method is now a static version of the
	 * get pizza method. So if I ever need to get
	 * a pizza by its ID, all I ahve to do is call:
	 * PizzaService.getPizza(id);
	 */
	public static Pizza getPizza(int id) {
		return pd.getPizza(id);
	}
	
	//The remaining methods follow the exact same pattern.
}
