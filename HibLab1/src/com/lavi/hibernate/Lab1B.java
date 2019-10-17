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
public class Lab1B {
	public static void main(String[] args) {
		Transaction tx = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee emp = (Employee)session.load(Employee.class,200);
			System.out.println("Employee Details::");
			System.out.println("EmpId::"+emp.getEid());
			System.out.println("EmpEmail::"+emp.getEmail());
			System.out.println("EmpId::"+emp.geteName());
			tx.commit();
			session.close();
			System.out.println("successfully loaded");
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}
}
