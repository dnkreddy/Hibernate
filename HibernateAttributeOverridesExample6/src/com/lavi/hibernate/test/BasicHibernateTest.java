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

			Address homeAddress = new Address();
			homeAddress.setStreet("Nandavaram");
			homeAddress.setCity("Nellore");
			homeAddress.setState("AndhraPredesh");
			homeAddress.setPinCode("524307");

			Address officeAddress = new Address();
			officeAddress.setStreet("Gopalan Enter Prices");
			officeAddress.setCity("Banglore");
			officeAddress.setState("Karnataka");
			officeAddress.setPinCode("524320");

			user.setHomeAddress(homeAddress);
			user.setOfficeAddress(officeAddress);
			user.setUserName("NarasaReddy");
			user.setDescription("Software Engineer");
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
