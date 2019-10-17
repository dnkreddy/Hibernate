package com.lavi.training.test;

import java.util.Date;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lavi.training.model.Student;
import com.lavi.training.util.HibernateUtil;

public class UpdateStudent {
	public static void main(String[] args) {
		
		System.out.println("Start of test classes");
		SessionFactory sf = HibernateUtil.getSF();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Student s1 = session.get(Student.class, 5,LockMode.UPGRADE_NOWAIT );
		System.out.println(s1.getStudName());
		s1.setFeeBal(2011);
		s1.setStudName("DNKRED");
		System.out.println("updating values");
		session.update(s1);
		System.out.println("updated values");
		tx.commit();
		session.close();
		System.out.println("End of Update class ");
		
	}

}
