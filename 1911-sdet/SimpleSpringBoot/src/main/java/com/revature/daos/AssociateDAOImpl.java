package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.entities.Associate;

@Component
public class AssociateDAOImpl implements AssociateDAO {

	@Override
	public Associate getAssociateById(int id) {
		
		if(id == 1) {
			Associate daniel = new Associate();
			daniel.setId(1);
			daniel.setName("Daniel");
			daniel.setPoints(9001);
			
			return daniel;
		} else if(id == 2) {
			Associate waluigi = new Associate();
			waluigi.setId(2);
			waluigi.setName("Waluigi");
			waluigi.setPoints(10);
			
			return waluigi;
		} else {
			Associate ruben = new Associate();
			ruben.setId(3);
			ruben.setName("Ruben");
			ruben.setPoints(11);
			
			return ruben;
		}
	}

	@Override
	public List<Associate> getAllAssociates() {
		
		List<Associate> associates = new ArrayList<Associate>();
		
		Associate daniel = new Associate();
		daniel.setId(1);
		daniel.setName("Daniel");
		daniel.setPoints(9001);
		
		Associate waluigi = new Associate();
		waluigi.setId(2);
		waluigi.setName("Waluigi");
		waluigi.setPoints(10);
		
		Associate ruben = new Associate();
		ruben.setId(3);
		ruben.setName("Ruben");
		ruben.setPoints(11);
		
		
		associates.add(daniel);
		associates.add(waluigi);
		associates.add(ruben);
		
		return associates;
	}

}
