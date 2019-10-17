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
public class UpdateTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			//RETRIEVE User Details
			User userValues = (User) session.get(User.class, 9);
			System.out.println("User Name :" + userValues.getUserName());
			
			//UPDATE User Details
			 userValues.setUserName("Lavi Technologies");
			 session.update(userValues);
			 System.out.println("User Details Updated Successfully..");
			tx.commit();
			session.close();
			
			/*Session session1 = HibernateUtil.getSession();
			Transaction tx1 = session1.beginTransaction();
			User userValues1 = (User) session1.get(User.class, 9);
			userValues.setUserName("LAVITECH");
			//session1.update(userValues);
			session1.merge(userValues);
			tx1.commit();
			*/
			
			
		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
