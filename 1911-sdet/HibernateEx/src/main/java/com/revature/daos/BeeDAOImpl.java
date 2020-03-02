package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Bee;
import com.revature.util.HibernateUtil;

public class BeeDAOImpl implements BeeDAO {

	public int insertBee(Bee b) { // Bee object is transient
		Session sess = HibernateUtil.getSession(); // Connect to the db
		int id = 0;

		try {
			sess.beginTransaction(); // Opens the transaction
			id = Integer.parseInt(sess.save(b).toString()); // Makes the Bee object persistent
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback(); // ??
		} finally {
			sess.close(); // Makes the Bee Object detached.
		}

		return id;
	}

	public List<Bee> selectAllBees() {
		Session session = HibernateUtil.getSession();
		List<Bee> bees = null;

		try {
			bees = session.createQuery("FROM Bee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bees;
	}

	public Bee selectBeeById(int id) {
		Session session = HibernateUtil.getSession();
		Bee bee = null;

		try {
			bee = (Bee) session.get(Bee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bee;
	}

	public void updateBee(Bee change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(change);
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void deleteBeeById(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(session.get(Bee.class, id));
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
