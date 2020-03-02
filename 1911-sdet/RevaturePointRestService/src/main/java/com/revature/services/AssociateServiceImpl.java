package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Associate;
import com.revature.repositories.AssociateRepository;

@Service
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	AssociateRepository ar;
	
	@Override
	public Associate createAssociate(Associate associate) {
		return ar.save(associate);
	}

	@Override
	public Associate getAssociateById(int id) {
		return ar.findById(id).get();
	}

	@Override
	public List<Associate> allAssociates() {
		return (List<Associate>) ar.findAll();
	}

	@Override
	public Associate updateAssociate(Associate change) {
		return ar.save(change);
	}

	@Override
	public boolean deleteAssociate(Associate associate) {
		try {
			ar.delete(associate);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Associate> getAssociateByName(String name) {
		return ar.findByName(name);
	}

	@Override
	public List<Associate> getAssociateByPoints(int points) {
		return ar.findByPoints(points);
	}
	
	@Override
	public List<Associate> getAssociateByNameAndPoints(String name, int points) {
		return ar.findByNameAndPoints(name, points);
	}

}
