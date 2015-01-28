package com.nijjwal.hibernate;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main{
	public static void main(String[] args) {
	
	
		Issues myissue = new Issues();
			
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Insert an object in the database
		/*
		myissue.setProject_title("Banana");
		myissue.setIssue_description("There are no bananas left in Texas!");
		myissue.setIssue_entered_on(new Date());
		session.save(myissue);
		*/
				
		//Retrieve the object
		/*
		myissue = (Issues) session.get(Issues.class, 1);

		System.out.println("Issue having an id of 1 is : "+ myissue.getProject_id());
		System.out.println("Project Title : "+ myissue.getProject_title());	
		System.out.println("Project Description : "+ myissue.getIssue_description());	
		System.out.println("Issue entered on : "+ myissue.getIssue_entered_on());
		*/	
	   
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
		
		
		/*
		//Create an object to store full name and age
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		//store full name
		String line = input.nextLine();
		
		//store age
		System.out.println("Please enter your age: ");
		int years = input.nextInt();
		
		//Print the information stored in the object
		System.out.println("Welcome "+ line + " you are "+ years+ " years old.");
		*/
		
		//launch(args);
	}

	/*
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/IssueTrackingLite.fxml"));
		Scene scene = new Scene(root, 600, 400);
		
		primaryStage.setResizable(true);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bunny's Issue Tracking System");
		primaryStage.show();
		
	}
	*/
}
