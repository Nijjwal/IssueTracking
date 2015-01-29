package com.nijjwal.hibernate;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class MainView extends Application{
	public static void main(String[] args) {
	
		
		Issues myissue = new Issues();	

			
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Your code goes here*/
		
		myissue = (Issues) session.get(Issues.class, 2);
		
		System.out.println("Title of project 2 is: "+ myissue.getProject_title());
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();	
		
			
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/IssueTrackingLite.fxml"));
		Scene scene = new Scene(root, 600, 400);
		
		primaryStage.setResizable(true);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bunny's Issue Tracking System");
		primaryStage.show();
		
	}
	
}
