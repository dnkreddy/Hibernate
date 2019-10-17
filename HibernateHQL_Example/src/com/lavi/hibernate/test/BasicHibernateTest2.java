package com.lavi.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.lavi.hibernate.model.UserDetails;
import com.lavi.hibernate.util.HibernateUtil;

/**
 * @author LaVi Technologies
 * 
 */
public class BasicHibernateTest2 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

		//Criteria crit = session.createCriteria(UserDetails.class);
		//crit.add(Restrictions.like("phoneNo", new Long(909093)));
		//crit.setFirstResult(1);
		//crit.setMaxResults(5);
		//crit.addOrder(Order.desc("userId"));
	/*	List<UserDetails> list = crit.list();

			System.out.println("User List Size : " + list.size());
				for (UserDetails userDetails : list) {
					System.out.println(userDetails.getUserId());
				}
			tx.commit();
			session.close();*/
			
			
			/*UserDetails details = session.load(UserDetails.class,7);
			System.out.println(details.getPhoneNo());*/
			
			UserDetails details1 = session.load(UserDetails.class,7);
			System.out.println(details1.getPhoneNo());
			details1.setPhoneNo(9777777);
			session.clear();
			details1.setUserId(10);
			session.merge(details1);
			
	          tx.commit();
				
				session.close();
			
			//	details1.setPhoneNo(77777777);
			//HibernateUtil.closeSession(session);
			
			Session s2 = sf.openSession();
			Transaction tx2 = s2.beginTransaction();
			UserDetails det2 = s2.load(UserDetails.class, 7);
			System.out.println(det2.getPhoneNo());
			
			//s2.merge(details1);
		
			tx2.commit();
			s2.close();
			
			
			

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}

	}

}
