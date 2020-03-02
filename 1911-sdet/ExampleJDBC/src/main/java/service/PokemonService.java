package service;

import java.util.List;

import dao.PokemonDAO;
import dao.PokemonDAOImpl;
import model.Pokemon;

public class PokemonService {

	public static PokemonDAO pd = new PokemonDAOImpl();
	
	//This is a static version of the DAO method.
	public static Pokemon getPokemon(int p_id) {
		return pd.getPokemon(p_id);
	}
	
	public static Pokemon getPokemon(String name) {
		return pd.getPokemon(name);
	}
	
	public static List<Pokemon> getAllPokemon() {
		return pd.getAllPokemon();
	}
	
	public static boolean addPokemon(Pokemon p) {
		return pd.addPokemon(p);
	}
	
	public static boolean updatePokemon(Pokemon change) {
		return pd.updatePokemon(change);
	}
	
	public static boolean deletePokemon(int p_id) {
		return pd.deletePokemon(p_id);
	}
}
