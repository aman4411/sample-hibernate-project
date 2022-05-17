package com.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Person person = new Person();
        person.setId(1);
        person.setAge(23);
        person.setName("Aman");
        
        Address address = new Address();
        address.setAddressId(213);
        address.setStreet("Street-2");
        address.setCity("Delhi");
        
        person.setAddress(address);
        
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        
        session.save(person);
        session.save(address);
        txn.commit();
        
        session.close();
        System.out.println(person);
        
	}

}
