package com.revature.daos;

import java.util.List;

import com.revature.models.Bee;

public interface BeeDAO {

	public int insertBee(Bee b);
    public List<Bee> selectAllBees();
    public Bee selectBeeById(int id);
    public void updateBee(Bee change);
    public void deleteBeeById(int id);
	
}
