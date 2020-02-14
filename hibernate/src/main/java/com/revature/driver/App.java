package com.revature.driver;

import com.revature.daos.FlowerDAOImpl;
import com.revature.models.Flower;

public class App {
	public static void main(String[] args) {
	 
		FlowerDAOImpl fd = new FlowerDAOImpl();
		Flower daffodil = new Flower(0, "Daffodill", 2);
		Flower rose = new Flower(0, "Rose", 5);
//		Flower tulip = new Flower(0, "Tulip", 5);

		daffodil.setId(fd.addFlower(daffodil));
		rose.setId(fd.addFlower(rose));
		// fd.addFlower(daffodil);
//	fd.addFlower(rose); 
//		fd.addFlower(tulip);
		System.out.println("====SELECT ALL FLOWERS===");
		System.out.println(fd.selectAllFlowers());
		
		System.out.println("====SELECT ROSE ===");
		System.out.println(fd.selectFlowerById(rose.getId()));
		
		rose.setPetals(30);
		fd.updateFlower(rose);
	 
		System.out.println("====UPDATE ROSE ===");
		System.out.println(fd.selectAllFlowers());
		
		fd.deleteFlowerById(rose.getId());
		
		System.out.println("====DELETE ROSE ===");
		System.out.println(fd.selectAllFlowers());
		}
}
