package dao;

import java.util.List;

import model.Pokemon;

public interface PokemonDAO {

	//CRUD operations for your Model.
	//Create
	//Read
	//Update
	//Delete
	
	public Pokemon getPokemon(int p_id);
	public Pokemon getPokemon(String name);
	public List<Pokemon> getAllPokemon();
	public boolean addPokemon(Pokemon p);
	public boolean updatePokemon(Pokemon change);
	public boolean deletePokemon(int p_id);
}
