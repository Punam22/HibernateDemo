package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.entity.Student;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		try {
			Student student = new Student();
			student.setFirstname("Poonam");
			student.setLastname("Patil");
			student.setEmail("p@gmail.com");
			session.beginTransaction();
			System.out.println("saving student data....");
			session.save(student);
			session.getTransaction().commit();
			System.out.println("done....");

		} finally {
			session.close();

		}

	}

}
