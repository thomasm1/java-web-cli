import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/Pokemon';
import { PokemonService } from 'src/app/service/pokemon.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  constructor(private pokeService :PokemonService) { }

  ngOnInit() {
    this.displayAllPokemon();
  }

  pokemonList :Pokemon[] = [];  // :Pokemon[] = :Array:Pokemon
  allPokemon :Observable<Pokemon[]> = this.pokeService.getAllPokemon();


  id :number;
  name :string;
  type :string;

  validInputs :boolean = false;
  validation :string = "All 3 fields are required";


  displayAllPokemon() {

    this.allPokemon.subscribe(
      //function to execute when the Observable
      //receives information because the call is successful.
      (response) => {
        this.pokemonList = response;
        console.log(this.pokemonList);
      },
      //function to execute when the Observabler receives
      //incorrect/faulty information -> call is unsuccessful.
      (response) => {
        return "Sorry it failed";
      }
    );
  }

  addPokemon() {
    this.validateInputFields();
    if(this.validInputs) {
      this.pokeService.addPokemon(new Pokemon(this.id, this.name, this.type)).subscribe(
        (response) => {
          console.log(response);
          let list = this.pokemonList.slice();
          list.push(response);
          this.pokemonList = list;
        },
        (response) => {
          console.log("Failed to add Pokemon");
          console.log(response);
        }
      );
    }
  }

  validateInputFields() {
    console.log(this.id);
    console.log(this.name);
    console.log(this.type);

    if(this.id == undefined ||
       this.name == undefined ||
       this.name == "" ||
       this.type == undefined ||
       this.type == "") {
      this.validInputs = false;
    }
    else {
      this.validInputs = true;
    }
  }

  validateFields(id :number, name :string, type :string) :string {

    this.validateInputFields();
    if(!this.validInputs)
      return this.validation;
    else {
      return "";
    }

  }

}
