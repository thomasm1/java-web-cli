package com.revature.services;

import java.util.List;

import com.revature.entities.Associate;

public interface AssociateService {

	public Associate createAssociate(Associate associate);
	public Associate getAssociateById(int id);
	public List<Associate> getAssociateByName(String name);
	public List<Associate> getAssociateByPoints(int points);
	public List<Associate> getAssociateByNameAndPoints(String name, int points);
	public List<Associate> allAssociates();
	public Associate updateAssociate(Associate change);
	public boolean deleteAssociate(Associate associate);
}
