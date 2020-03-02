package dao_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Pokemon;
import service.PokemonService;

public class PokemonDAOTesting {

	@Test
	public void add_Pokemon() {
		
		Pokemon p = new Pokemon("Jigglypuff", "The singing pokemon");
		assertTrue(PokemonService.addPokemon(p));
		PokemonService.deletePokemon(PokemonService.getPokemon("Jigglypuff").getP_id());
	}

}
