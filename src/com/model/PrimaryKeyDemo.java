package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		try {
			Student student = new Student("Poonam", "Patil", "p@gmail.com");
			Student student1 = new Student("Rohit", "Khudabadi", "r@gmail.com");
			Student student2 = new Student("Anup", "Kadam", "a@gmail.com");
			Student student3 = new Student("Namrata", "Surushe", "n@gmail.com");

			session.beginTransaction();
			System.out.println("saving student data....");
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("done....");

		} finally {
			session.close();

		}

	}

}
