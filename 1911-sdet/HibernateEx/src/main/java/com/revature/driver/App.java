package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.daos.BeeDAO;
import com.revature.daos.BeeDAOImpl;
import com.revature.daos.BeehiveDAO;
import com.revature.daos.BeehiveDAOImpl;
import com.revature.daos.FlowerDAOImpl;
import com.revature.models.Bee;
import com.revature.models.Beehive;
import com.revature.models.Flower;
import com.revature.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		System.out.println("====APP START====");
		
		FlowerDAOImpl fd = new FlowerDAOImpl();
		
		Flower daffodil = new Flower("Daffodil", 2);
		Flower rose = new Flower("Rose", 15);
		
		daffodil.setId(fd.addFlower(daffodil));
		rose.setId(fd.addFlower(rose));
		
		System.out.println("===SELECT ALL FLOWERS===");
		System.out.println(fd.selectAllFlowers());
		
		System.out.println("===SELECT ROSE===");
		System.out.println(fd.selectFlowerById(rose.getId()));
		
		rose.setPetals(30);
		fd.updateFlower(rose);
		
		System.out.println("===SHOW UPDATED ROSE===");
		System.out.println(fd.selectAllFlowers());
		
		fd.deleteFlowerById(rose.getId());
		
		System.out.println("===SHOW ALL FLOWERS===");
		System.out.println(fd.selectAllFlowers());
		
		
		//-------------------
		
		BeehiveDAO bhd = new BeehiveDAOImpl();
		
		Beehive bh1 = new Beehive(7);
		Beehive bh2 = new Beehive(20);
		
		bhd.addBeehive(bh1);
		bhd.addBeehive(bh2);
		
		System.out.println("===SELECT ALL BEEHIVES===");
		System.out.println(bhd.selectAllBeehives());
		
		BeeDAO bd = new BeeDAOImpl();
		
		Bee bee1 = new Bee(5, bh1);
		Bee bee2 = new Bee(4, bh1);
		
		List<Flower> flowers = new ArrayList<Flower>();
		flowers.add(daffodil);
		
		bee1.setFlowers(flowers);
		bee2.setFlowers(flowers);
		
		bd.insertBee(bee1);
		bd.insertBee(bee2);
		
		System.out.println("===SELECT ALL BEES===");
		System.out.println(bd.selectAllBees());
		
		/*
		 * Criteria vs Query
		 * 
		 * Criteria and Query are both interfaces of
		 * Hibernate. Objects of these types can be made
		 * using sessions. They both serve similar purposes.
		 * They are both used to grab data from the database,
		 * just in different ways.
		 * 
		 * 
		 * Query uses SQL or HQL
		 */
		
		
		System.out.println("=====Query=====");
		
		Query query;
		Session sess = HibernateUtil.getSession();
		System.out.println("===GET ALL BEES===");
		String hql = "FROM Bee";
		query = sess.createQuery(hql);
		System.out.println(query.list() + "\n");
		
		System.out.println("==PARAMETERIZED HQL==");
		hql = "FROM Bee WHERE id = :id";
		query = sess.createQuery(hql);
		query.setParameter("id", bee2.getId());
		System.out.println(query.uniqueResult() + "\n");
		
		/*
		 * Criteria is an object oriented approach to
		 * grabbing records from the database
		 * 
		 * Instead of using one of the query languages,
		 * the Criteria interface can grab values from
		 * the database using what is called 'criteria'
		 */
		
		System.out.println("===CRITERIA GET ALL BEES===");
		
		Criteria crit;
		//grabs all the records from the DB that are
		//from the Bee class.
		crit = sess.createCriteria(Bee.class);
		System.out.println(crit.list() + "\n");
		
		crit.add(Restrictions.idEq(bee1.getId()));
		
		System.out.println(crit.uniqueResult() + "\n");
		
		Criteria crit2 = sess.createCriteria(Beehive.class);
		crit2.setProjection(Projections.sum("honey"));
		System.out.println("The total amount of honey available is: " + crit2.uniqueResult());
		
		
		//-------Native SQL---------
		String sql = "SELECT * FROM Beehive WHERE bh_id > :value";
		SQLQuery squery = sess.createSQLQuery(sql);
		squery.addEntity(Beehive.class);
		squery.setParameter("value", 50);
		System.out.println(squery.list());
	}
}
