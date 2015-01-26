package com.nijjwal.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class Main {
	public static void main(String[] args) {
	
		Issues myissue = new Issues();
			
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
				
		//Retrieve the object
		myissue = (Issues) session.get(Issues.class, 1);
		myissue.setProject_title("Fatigue");
		
		session.delete(myissue);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
	}
}
