package com.revature.daos;

import java.util.List;

import com.revature.models.Beehive;

public interface BeehiveDAO {
	
	public void addBeehive(Beehive bh);
	public List<Beehive> selectAllBeehives();
	public Beehive selectBeehiveById(int id);
	public void updateBeehive(Beehive change);
	public void deleteBeehiveById(int id);

}
