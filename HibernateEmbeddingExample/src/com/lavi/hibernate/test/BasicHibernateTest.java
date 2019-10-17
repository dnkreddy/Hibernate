package com.lavi.hibernate.test;

import java.util.Date;

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
			Address address = new Address();
			address.setStreet("Marathahalli");
			address.setCity("Bangaloe");
			address.setState("Karnataka");
			address.setPinCode("560016");
			user.setUserName("Lavi1");
			user.setAddress(address);
			user.setDescription("Training Institute");
			user.setDateCreated(new Date());
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
