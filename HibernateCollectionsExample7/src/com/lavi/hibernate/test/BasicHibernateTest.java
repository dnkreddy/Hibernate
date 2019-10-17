package com.lavi.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.Address;
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

			User user = new User();
			Address address1 = new Address();
			address1.setStreet("Marathahalli1");
			address1.setCity("Bangalore");
			address1.setState("Karnataka");
			address1.setPinCode("560037");

			Address address2 = new Address();
			address2.setStreet("Marathahalli");
			address2.setCity("Banglore");
			address2.setState("Karnataka");
			address2.setPinCode("560037");

			user.setUserName("Lavi");
			user.getListOfAddresses().add(address1);
			user.getListOfAddresses().add(address2);

			session.save(user);
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
