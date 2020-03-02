package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.AssociateDAO;
import com.revature.entities.Associate;

@Service
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	AssociateDAO ad;
	
	@Override
	public Associate getAssociate(int id) {
		return ad.getAssociateById(id);
	}

	@Override
	public List<Associate> allAssociates() {
		return ad.getAllAssociates();
	}
	
	public List<Associate> allRAssociates() {
		List<Associate> associates = ad.getAllAssociates();
		
		List<Associate> rAssociates = new ArrayList<Associate>();
		for(Associate a : associates) {
			if (a.getName().charAt(0) == 'R')
				rAssociates.add(a);
		}
		
		return rAssociates;
	}
	
	public List<Associate> allAssociatesByLetter(char character) {
		List<Associate> associates = ad.getAllAssociates();
		
		List<Associate> associateList = new ArrayList<Associate>();
		for(Associate a : associates) {
			if (a.getName().charAt(0) == character)
				associateList.add(a);
		}
		
		return associateList;
	}

}
