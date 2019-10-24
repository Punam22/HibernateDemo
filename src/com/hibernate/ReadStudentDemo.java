package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		try {
			Student student = new Student();
			student.setFirstname("Anjali");
			student.setLastname("Patil");
			student.setEmail("a@gmail.com");
			session.beginTransaction();
			System.out.println("saving student data....");
			System.out.println(student);
			session.save(student);
			session.getTransaction().commit();

			// Get data from database
			session = sessionfactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("student is " + student.getId());

			Student myStudent = session.get(Student.class, student.getId());
			session.getTransaction().commit();
			System.out.println("Hi" + myStudent);
			System.out.println("done....");

		} finally {
			session.close();

		}

	}

}
