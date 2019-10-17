package com.lavi.hibernate.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

			Query query = session
					.createQuery("select userName from UserDetails");

			query.setFirstResult(5);
			query.setMaxResults(10);

			@SuppressWarnings({ "unchecked" })
			List<String> list = query.list();

			System.out.println("User List Size : " + list.size());

			for (String user : list) {
				System.out.println("User : " + user);
			}

			tx.commit();
			session.close();

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			ex.printStackTrace();
			tx.rollback();
		}

	}

}
