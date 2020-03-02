package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AssociateService;

@RestController
public class AssociateController {

	@Autowired
	AssociateService aserv;
	
	@RequestMapping(value = "/associates")
	public String getAllAssociates() {
		return aserv.allAssociates().toString();
	}
	
	@GetMapping(value = "/associates/{id}")
	public String getAssociate(@PathVariable("id") int id) {
		return aserv.getAssociate(id).toString();
	}
	
	@GetMapping(value = "/associates/letter={character}")
	public String getAssociateByLetter(@PathVariable("character") char character) {
		return aserv.allAssociatesByLetter(character).toString();
	}
	
	
}
