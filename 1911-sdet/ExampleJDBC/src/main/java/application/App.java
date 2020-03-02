package application;

import java.util.List;

import model.Pokemon;
import service.PokemonService;

public class App {

	public static void main(String[] args) {
		
//		PokemonDAO pd = new PokemonDAOImpl();
//		
//		Pokemon p = pd.getPokemon(100);
		
		Pokemon p = PokemonService.getPokemon(100);
		Pokemon p2 = PokemonService.getPokemon("Seaking");
		
		Pokemon p3 = new Pokemon("Pikachu","The electric mouse pokemon");
		
		
		List<Pokemon> pokeList = PokemonService.getAllPokemon();
		
		System.out.println("==Get by ID===");
		System.out.println(p);
		System.out.println("==Get by Name===");
		System.out.println(p2);
		System.out.println("==Get All===");
		System.out.println(pokeList);
		System.out.println("==Add Pokemon===");
		System.out.println(PokemonService.addPokemon(p3));
		System.out.println(PokemonService.getPokemon("Pikachu"));
		
		p3 = PokemonService.getPokemon(p3.getName());
		p3.setBio("THE ELECTRIC POKEMON");
		System.out.println("==Update Pokemon===");
		System.out.println(PokemonService.updatePokemon(p3));
		System.out.println(PokemonService.getPokemon(p3.getP_id()));
		System.out.println("==Delete Pokemon===");
		System.out.println(PokemonService.deletePokemon(p3.getP_id()));
		
	}
}
