package com.hibernate_object_states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sample_hibernate_project.Student;

public class StateDemo {

	public static void main(String[] args) {
		// Demo to show different states of object in hibernate
		//Transient State  - when object is created and it's properties are initialised.
		//Persistent State - when object is saved in session and database.
		//Detached State  - when session is closed and object is in database.
		//Removed State - when object is in session but deleted from database.
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student student = new Student();
		student.setRollNo("12");
		student.setName("Aman");
		student.setCity("Faridabad");
		//student : Transient State
		
		Session session = factory.openSession();
		
		session.save(student);
		//student : Persistent State
		
		//any change made in property of object in persistent state will also gets reflect in database.
		student.setCity("Delhi");
		
		session.close();
		//student : Detached State
		
		factory.close();
	}

}
