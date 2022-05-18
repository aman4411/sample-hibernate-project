package com.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.sample_hibernate_project.Student;

public class HQLDemo {

	public static void main(String[] args) {
		// Demo to show how to use Hibernate Query Language (HQL)

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		//example 1 - normal select query
		String queryString = "from Student";
		Query query = session.createQuery(queryString);
		List<Student> students = query.getResultList();
		
		for(Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("--------------------------------");
		
		//example 2 - where clause query
		String queryString2 = "from Student where name='Aman'";
		Query query2 = session.createQuery(queryString2);
		students = query2.getResultList();
		
		for(Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("--------------------------------");
		
		Transaction txn = session.beginTransaction();
		
		//example 3 - set parameter in query dynamically
		String queryString3 = "update Student set city=:c where name=:n";
		Query query3 = session.createQuery(queryString3);
		query3.setParameter("c", "Goa");
		query3.setParameter("n", "Aman");
		int rows = query3.executeUpdate();
		txn.commit();
		
		System.out.println(rows + " rows updated.");
		
		System.out.println("--------------------------------");
		
		//example 4 - fetch data from 2 tables using join
		String queryString4 = "select q.questionId,q.question,a.answer from Question q INNER JOIN q.answers a";
		Query query4 = session.createQuery(queryString4);
		List<Object[]> questions = query4.getResultList();
		
		for(Object[] obj : questions) {
			System.out.println(Arrays.toString(obj));
		}
		
		session.close();
		factory.close();
		
	}

}
