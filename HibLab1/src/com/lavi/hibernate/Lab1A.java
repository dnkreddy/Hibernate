package com.lavi.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * 
 * @author LaViTechnologies
 *
 */
public class Lab1A {
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee e1 = new Employee();
			e1.setEid(200);
			e1.seteName("Lavi");
			e1.setEmail("Lavi@pp.com");
			e1.setEphoneNo(90366);
			session.save(e1);
			tx.commit();
			session.close();
			System.out.println("successfully saved");
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}
}