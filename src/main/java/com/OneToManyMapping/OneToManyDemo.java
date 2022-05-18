package com.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToManyDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question question = new Question();
        question.setQuestionId(112);
        question.setQuestion("What is Java?");
        
        Answer answer1 = new Answer();
        answer1.setAnswerId(123);
        answer1.setAnswer("Java is a programming language");
        answer1.setQuestion(question);
        
        Answer answer2 = new Answer();
        answer2.setAnswerId(124);
        answer2.setAnswer("Java is based on object oriented programming");
        answer2.setQuestion(question);
        
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(answer1);
        answers.add(answer2);
        
        question.setAnswers(answers);
        
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction(); 
        
        session.save(question);
        session.save(answer1);
        session.save(answer2);
        
        txn.commit();
        
        session.close();
        System.out.println(question);
	}

}
