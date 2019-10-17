package com.lavi.hibernate.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.UserDetails;
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
			//First Level Cache associated with session
			UserDetails user1 = (UserDetails) session.get(UserDetails.class,7);
			System.out.println(user1.getUserName());
			//UserDetails user2 = (UserDetails) session.get(UserDetails.class,8);
			UserDetails user2 = (UserDetails) session.get(UserDetails.class,7);
			System.out.println(user2.getUserName());
			tx.commit();
			session.close();
			Session session2 = HibernateUtil.getSession();
			Transaction tx2 = session2.beginTransaction();
            //Second Level cache associated with Session factory
			//UserDetails user3 = (UserDetails) session2.get(UserDetails.class,9);
			UserDetails user3 = (UserDetails) session2.get(UserDetails.class,7);
            System.out.println(user3.getUserName());
			tx2.commit();
			session2.close();
		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getMessage());
			tx.rollback();
		}

	}
}
