package com.revature.daos;

import java.util.List;

import com.revature.models.Flower;

public interface FlowerDAO {
	
	public int addFlower(Flower f);
	public List<Flower> selectAllFlowers();
	public Flower selectFlowerById(int id);
	public void updateFlower(Flower change);
	public void deleteFlowerById(int id);
	
}
