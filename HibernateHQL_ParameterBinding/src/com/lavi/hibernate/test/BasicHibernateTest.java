package com.lavi.hibernate.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.UserDetails;
import com.lavi.hibernate.util.HibernateUtil;

/**
* @author Lavi Technologies
 * 
 */
public class BasicHibernateTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {

			String minUserId = "10";
			String userName = "Lav1";
			String hqlQuery = "from UserDetails where userId > :uId and userName = :uName";
			Query query = session.createQuery(hqlQuery);
			query.setInteger("uId", Integer.parseInt(minUserId));
			query.setString("uName", userName);
			

			@SuppressWarnings({ "unchecked" })
			List<UserDetails> list = query.list();

			System.out.println("User List Size : " + list.size());

			for (UserDetails user : list) {
				System.out.println("User : " + user.getUserName());
			}

			tx.commit();
			session.close();

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getMessage());
			ex.printStackTrace();
			tx.rollback();
		}

	}

}
