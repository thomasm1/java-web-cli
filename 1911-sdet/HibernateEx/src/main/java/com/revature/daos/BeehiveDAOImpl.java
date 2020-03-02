package com.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Beehive;
import com.revature.util.HibernateUtil;

public class BeehiveDAOImpl implements BeehiveDAO {

	public void addBeehive(Beehive bh) {
		Session sess = HibernateUtil.getSession();
		
		try {
			sess.beginTransaction();
			/*
			 * Persist vs Save
			 * 
			 * Persist will save to the database and
			 * has a void return
			 * 
			 * Save will save to the database and
			 * returns a serializable identifier value (id).
			 */
			sess.persist(bh);
			sess.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			sess.getTransaction().rollback();
		} finally {
			sess.close();
		}	
	}

	public List<Beehive> selectAllBeehives() {

		Session session = HibernateUtil.getSession();
		List<Beehive> beehives = null;

		try {
			beehives = session.createQuery("FROM Beehive").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return beehives;
	}

	public Beehive selectBeehiveById(int id) {
		Session sess = HibernateUtil.getSession();
		Beehive bh = null;
		
		try {
			/*
			 * Get vs Load
			 * 
			 * get()  - Eager loading - immediately
			 * go to the database and get all the
			 * information associated with the object.
			 * 
			 * load() - Lazy loading - will return a
			 * proxy object with many fields not
			 * having a value. Those values are only
			 * loaded when they are specifically 
			 * requested later in the code.
			 */
			bh = (Beehive) sess.load(Beehive.class, id);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return bh;
	}

	public void updateBeehive(Beehive change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			/*
			 * Update vs Merge
			 * 
			 * Hibernate does not allow two object
			 * with the same id in the same session.
			 * 
			 * 'Update' on a object in the session with
			 * the same id will throw an exception, because
			 * it doesn't know which object should actually
			 * be changed.
			 * 
			 * 'Merge' will replace the object with the new object
			 * in the session.
			 * 
			 * saveOrUpdate - saves if not in DB, updates otherwise
			 * 
			 */
			sess.merge(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
	}

	public void deleteBeehiveById(int id) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(session.get(Beehive.class, id));
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
