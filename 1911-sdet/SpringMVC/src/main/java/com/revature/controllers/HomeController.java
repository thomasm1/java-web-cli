package com.revature.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String sayHello() {
		return "Hello there ladies and gentlemen. Are you ready to rock?";
	}
	
	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	String getAllCharacters() {
		
		//some call to a service layer
		//then format my response
		
		return "Peach Daisy Yoshi Mario";
	}
	
	@RequestMapping(value = "/characters/{id}", method = RequestMethod.GET)
	String getCharacter(@PathVariable("id") int id) {
		
		//return CharacterService.getCharacter(id);
		return characterServiceGetCharacter(id);
	}

	private String characterServiceGetCharacter(int id) {
		String[] characters = {"Yoshi", "Peach", "Daisy", "Mario" };
		
		if(id >= 0 && id < 4)
			return characters[id];
		else
			return "The character you are looking for is in another app";
	}
	
	
}
