package com.lavi.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.User;
import com.lavi.hibernate.model.Vehical;
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
			Vehical vehical1 = new Vehical();
			vehical1.setVehicalName("CAR");
			Vehical vehical2 = new Vehical();
			vehical2.setVehicalName("ZEEP");
			user.setUserName("Lavi");
			user.getVehicalList().add(vehical1);
			user.getVehicalList().add(vehical2);
			vehical1.setUserDetails(user);
			vehical2.setUserDetails(user);
			//comment below for cascade
			session.save(vehical1);
			session.save(vehical2);
			session.save(user);
			tx.commit();
			session.close();
			System.out
					.println("User And Vehical Details Inserted Successfully");

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getMessage());
			tx.rollback();
		}
	}
}
