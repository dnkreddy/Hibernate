package com.lavi.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.Bank;
import com.lavi.hibernate.util.HibernateUtil;

/**
 *  @author LaviTechnologies
 * 
 */
public class LoadTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
         Bank b = session.get(Bank.class,1);
         b.setBankName("ICICI");
         tx.commit();
         session.close();
		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
