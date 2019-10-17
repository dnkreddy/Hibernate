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
public class DeleteTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			//RETRIEVE User Details
			User userValues = (User) session.get(User.class, 9);
			System.out.println("User Name :" + userValues.getUserName());
			 //DELETE User Details
			session.delete(userValues);
			System.out.println("User Values Deleted successfully..");
			tx.commit();
			session.close();
		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
