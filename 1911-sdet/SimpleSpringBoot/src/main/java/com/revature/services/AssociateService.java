package com.revature.services;

import java.util.List;

import com.revature.entities.Associate;

public interface AssociateService {

	public Associate getAssociate(int id);
	public List<Associate> allAssociates();
	public List<Associate> allRAssociates();
	public List<Associate> allAssociatesByLetter(char character);
}
