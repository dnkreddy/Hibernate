package com.lavi.hibernate.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

			Query query = session
					.createQuery("from UserDetails where userId > 100");

			@SuppressWarnings("rawtypes")
			List<UserDetails> list = query.list();

			System.out.println("User List Size : " + list.size());

			tx.commit();
			session.close();

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}

	}

}
