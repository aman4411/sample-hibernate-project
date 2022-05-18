package com.ManyToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Employee e1 = new Employee();
        Employee e2 = new Employee();
       
        e1.setEmployeeId(34);
        e1.setName("Aman");
        
        e2.setEmployeeId(35);
        e2.setName("Ram");
        
        Project p1 = new Project();
        Project p2 = new Project();
        
        p1.setProjectId(121);
        p1.setProjectName("Library Management System");
        
        p2.setProjectId(122);
        p2.setProjectName("Ecommerce Website");
        
        List<Employee> employeeList = new ArrayList<Employee>();
        List<Project> projectList = new ArrayList<Project>();
        employeeList.add(e1);
        employeeList.add(e2);
        projectList.add(p1);
        projectList.add(p2);
        
        e1.setProjects(projectList);
        p2.setEmployees(employeeList);
        
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction(); 
        
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        
        txn.commit();
        
        session.close();
        
	}

}
