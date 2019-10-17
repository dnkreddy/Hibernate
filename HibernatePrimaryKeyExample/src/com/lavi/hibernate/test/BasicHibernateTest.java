package com.lavi.hibernate.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.User;
import com.lavi.hibernate.util.HibernateUtil;

/**
 * @author LaVi Technologies
 * 
 */
public class BasicHibernateTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {

			User user1 = new User();
			user1.setUserName("Lavi1");
			user1.setAddress("Banglore");
			user1.setDescription("Software Engineer");
			user1.setDateCreated(new Date());

			User user2 = new User();
			user2.setUserName("Lavi2");
			user2.setAddress("Banglore");
			user2.setDescription("Software Engineer");
			user2.setDateCreated(new Date());

			session.save(user1);
			session.save(user2);
			tx.commit();
			session.close();

			System.out.println("User Details Inserted Successfully...");

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
