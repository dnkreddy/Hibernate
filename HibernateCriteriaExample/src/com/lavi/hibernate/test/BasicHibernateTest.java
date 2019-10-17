package com.lavi.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.lavi.hibernate.model.UserDetails;
import com.lavi.hibernate.util.HibernateUtil;

/**
 * @author LaviTechnolgoies
 * 
 */
public class BasicHibernateTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {

			Criteria criteria = session.createCriteria(UserDetails.class);
			//setting pagination for criteria
			/*criteria.setFirstResult(5);  
			criteria.setMaxResults(10);*/
		
			// Adding Restrictions for Criteria
			//criteria.add(Restrictions.eq("userName", "User 5"));
			// criteria.add(Restrictions.ge("userId", 100));
			// criteria.add(Restrictions.like("userName", "Use%"));
			// criteria.add(Restrictions.between("userId", 90, 100));
			// criteria.add(Restrictions.or(
			// Restrictions.between("userId", 90, 100),
			// Restrictions.between("userId", 95, 104)));

			// Adding projections Projections
			// criteria.setProjection(Projections.max("userId"));
			// criteria.setProjection(Projections.count("userId"));
			
			//If you enable below projection it will result list of userIds instead of 
			// list of userDetails
			//criteria.setProjection(Projections.property("userId"));

			// criteria.addOrder(Order.desc("userId"));

			// Adding example for criteria instead of restrictions
			/*UserDetails exampleUser = new UserDetails();
			// primary keys and null values are not considered
			exampleUser.setUserId(100);
			exampleUser.setUserName("User 1%");
            //To exlude any particular columns
			// Example ex = Example.create(exampleUser).excludeProperty("userName");
			Example ex = Example.create(exampleUser).enableLike();

			criteria.add(ex);*/

			@SuppressWarnings({ "unchecked" })
			List<UserDetails> list = (List<UserDetails>) criteria.list();
			System.out.println("List Size : " + list.size());

			for (UserDetails user : list) {
				System.out.println("User : " + user.getUserName());
			}

			tx.commit();
			session.close();

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}

	}
}
