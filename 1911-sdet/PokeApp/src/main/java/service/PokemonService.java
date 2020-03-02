package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import db.FakeDB;
import model.Pokemon;

public class PokemonService {
	
	public static Pokemon getPokemon(int id) {
		return FakeDB.team.get(id);
	}
	
	public static void addPokemon(Pokemon p) {
		FakeDB.team.put(p.getId(), p);
	}
	
	public static List<Pokemon> getAllPokemon() {
		
		Set<Integer> keys = FakeDB.team.keySet();
		List<Pokemon> pokeList = new ArrayList<Pokemon>();
		
		for(Integer key : keys) {
			pokeList.add(FakeDB.team.get(key));
		}
		
		return pokeList;		
	}

}
