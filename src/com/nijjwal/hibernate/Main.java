package com.nijjwal.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class Main {
	public static void main(String[] args) {

		Student student = new Student();
		student.setName("Monster123");
		student.setBirthDate(new Date());
		
		
		
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("419-285-xxxx");
		
		//this is an important step
		studentDetail.setStudent(student);
		

		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		//Please note I am not saving student object but still it will be saved in database
		//that's the magic of one to one mapping
		session.save(studentDetail);

		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
	}
}
