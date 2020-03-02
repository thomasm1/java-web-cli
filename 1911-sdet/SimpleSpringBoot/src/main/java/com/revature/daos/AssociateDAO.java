package com.revature.daos;

import java.util.List;

import com.revature.entities.Associate;

public interface AssociateDAO {

	public Associate getAssociateById(int id);
	public List<Associate> getAllAssociates();
	
}
