package com.lavi.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author LaviTechnolgoies
 * 
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;

	static {
		try {
			SESSION_FACTORY = new Configuration().configure(
					"config/hibernate.cfg.xml").buildSessionFactory();

		} catch (HibernateException ex) {
			throw new ExceptionInInitializerError(
					"Exception building SessionFactory: " + ex.getMessage());
		}
	}

	public static Session getSession() throws HibernateException {
		return SESSION_FACTORY.openSession();
	}

	public static void closeSession(Session session) throws HibernateException {
		if (session != null) {
			session.close();
		}
	}
}
