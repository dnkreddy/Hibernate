package com.lavi.training.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lavi.training.model.Student;
import com.lavi.training.util.HibernateUtil;

public class Create {
	public static void main(String[] args) {
		System.out.println("Start of test classes");
		SessionFactory sf = HibernateUtil.getSF();
		Session session = sf.openSession();

		// s1.setStudId(11);
		for (int i = 0; i < 10; i++) {
			Transaction tx = session.beginTransaction();
			Student s1 = new Student();
			s1.setStudName("Naveen1" + i);
			s1.setFeeBal(2000 + i * 10);
			s1.setStudJoinDate(new Date());
			session.save(s1);
			tx.commit();
		}

		session.close();

		sf.close();

		System.out.println("End of test classes");

	}
}
