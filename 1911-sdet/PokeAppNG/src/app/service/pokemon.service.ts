import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/Pokemon';
import { Greeting } from '../models/Greeting';

// @Injectable is a decorator that marks a class as a target for
// dependency injection. The class needs to have the HttpClient
// object injected into it. This class is a candidate for dependency
// injection because it is declared inside the AppModule's providers array.
@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http :HttpClient) { }


  getAllPokemon() :Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>("http://localhost:8080/PokeApp/getAllPokemon.do");
  }

  addPokemon(poke :Pokemon) :Observable<Pokemon> {
    return this.http.post<Pokemon>("http://localhost:8080/PokeApp/addPokemon.do", poke, {headers: this.headers});
  }

}
