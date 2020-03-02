package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.aspects.Authorized;
import com.revature.entities.Associate;
import com.revature.services.AssociateService;

@RestController
public class AssociateController {

	@Autowired
	AssociateService as;
	
	@RequestMapping(value="/associates", method=RequestMethod.POST, consumes = "application/json")
	public Associate createAssociate(@RequestBody Associate associate) {
		System.out.println(associate);
		return as.createAssociate(associate);
	}
	
	@GetMapping(value="/associates")
	public List<Associate> allAssociates() {
		return as.allAssociates();
	}
	
	@GetMapping(value="/associates/{id}")
	public Associate getAssociateById(@PathVariable("id") int id) {
		return as.getAssociateById(id);
	}
	
	@GetMapping(value="/associates/search")
	public List<Associate> getAssociateByName(@RequestParam(required=false) String name, @RequestParam(required=false) Integer points) {
		
		if(name != null && points != null) {
			return as.getAssociateByNameAndPoints(name, points);
		}
		else if(name != null) {
			return as.getAssociateByName(name);
		}
		else {
			return as.getAssociateByPoints(points);
		}
	
	}
	
	
	@PutMapping(value="/associates", consumes="application/json")
	public Associate updateAssociate(@RequestBody Associate change) {
		return as.updateAssociate(change);
	}
	
	@Authorized
	@DeleteMapping(value="/associates/{id}")
	public boolean removeAssociate(@PathVariable("id") int id) {
		return as.deleteAssociate(as.getAssociateById(id));
	}
	
	@PostMapping(value="/login")
	public boolean loginAssociate(@RequestBody Associate associate, HttpSession httpSession) {
		
		String username = httpSession.getAttribute("login_attempt_username").toString();
		
		if(as.getAssociateByNameAndPoints(associate.getName(), associate.getPoints()) != null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
}
