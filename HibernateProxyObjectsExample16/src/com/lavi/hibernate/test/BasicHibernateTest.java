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
			address1.setStreet("Marathahalli");
			address1.setCity("Bangalore");
			address1.setState("Karnataka");
			address1.setPinCode("560016");

			Address address2 = new Address();
			address2.setStreet("Marathahalli");
			address2.setCity("Banglore");
			address2.setState("Karnataka");
			address2.setPinCode("560016");

			user.setUserName("Lavi1");
			user.getListOfAddresses().add(address1);
			user.getListOfAddresses().add(address2);

			session.save(user);
			tx.commit();
			session.close();

			System.out.println("User Details Inserted Successfully...");

			User userDetails = null;
			session = HibernateUtil.getSession();
			userDetails = (User) session.get(User.class, 1);
			session.close(); // LazyInitializationException
			System.out.println("UserDetais Size : "
					+ userDetails.getListOfAddresses().size());

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
