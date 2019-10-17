package com.lavi.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.lavi.hibernate.model.User;
import com.lavi.hibernate.util.HibernateUtil;
/**
 * @author Lavi Technologies
 * 
 */
public class ReadTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		try {
			//RETRIEVE User Details
			User userValues = (User) session.get(User.class, 1);
			System.out.println("User ID :" + userValues.getUserId());
			System.out.println("User Name :" + userValues.getUserName());
			System.out.println("Phone No :" + userValues.getPhoneNo());
			session.close();
		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
		}
	}
}
