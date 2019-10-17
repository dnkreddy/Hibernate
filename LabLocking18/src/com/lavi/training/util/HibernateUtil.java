package com.lavi.training.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private HibernateUtil() {
		
	}
	
	private static SessionFactory sf = null;
	
	public static SessionFactory getSF() {
		if(sf == null) {
			Configuration conf = new Configuration().configure();
			sf = conf.buildSessionFactory();
		}
		return sf;
	}

}
