package com.lavi.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.User;
import com.lavi.hibernate.util.HibernateUtil;
/**
 * @author Lavi Technologies
 * 
 */
public class CreateTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			// CREATE User Details
			long phoneNo = 909090;
			 for (int i = 1; i < 10; i++) {
			 User user = new User();
			 user.setUserId(i);
			 user.setUserName("User " + i);
			 phoneNo = phoneNo+1;
			 user.setPhoneNo(phoneNo);
			 session.save(user);
			 }
			 System.out.println("User Details Inserted Successfully...");
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
