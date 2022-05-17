package com.sample_hibernate_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Project Started");
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student = new Student("114","Aman","Delhi");
        
        //save student object in database
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        session.save(student);
        txn.commit();
        session.close();
        
        System.out.println(student);
    }
}
