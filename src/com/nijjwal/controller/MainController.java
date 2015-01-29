package com.nijjwal.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.nijjwal.hibernate.Issues;

public class MainController implements Initializable{
	
	private String project_title =  "No title found!";
	private String project_description = "No description available!";
	
	@FXML
	private Label messageBar;
	
	@FXML
	private TextField synopsis;
	
	@FXML
	private TextField projectTitle;
	
	@FXML
	private TextArea issueDescription;
	
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
	}

	public void showGreeting(ActionEvent event)
	{	
		
		boolean error = false; 
			
		Issues myissue = new Issues();	

		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Your code goes here*/
		String input = synopsis.getText();
		
		int project_id = Integer.parseInt(input);
				
		if((Issues) session.get(Issues.class, project_id) != null)
		{
			myissue = (Issues) session.get(Issues.class, project_id);
		    project_title = myissue.getProject_title();
		    project_description = myissue.getIssue_description();
		}else
		{
			error = true;
		}

		
		if(error == true)
		{
			messageBar.setText("Item not found!");
		}
		else
		{
			messageBar.setText(project_title);
		}
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	public void saveIssue()
	{
		Issues newissue = new Issues();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		/*Your code here*/
		//get all user input
		//id is auto increment
		newissue.setProject_title(projectTitle.getText());
		newissue.setIssue_description(issueDescription.getText());
		newissue.setIssue_entered_on(new Date());

		
		//Save the object
		session.save(newissue);
	
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
	
	
	public void deleteIssue(ActionEvent event)
	{	
		
		boolean error = false; 
			
		Issues myissue = new Issues();	

		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Your code goes here*/
		String input = synopsis.getText();
		
		int project_id = Integer.parseInt(input);
				
		if((Issues) session.get(Issues.class, project_id) != null)
		{
			myissue = (Issues) session.get(Issues.class, project_id);
		}
		else
		{
			error = true;
		}

		
		if(error == true)
		{
			messageBar.setText("Item not found!");
		}
		else
		{
			session.delete(myissue);
		}
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	public void updateIssue()
	{
		boolean error = false; 
		
		Issues update_issue = new Issues();
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/*Your code goes here*/
		String input = synopsis.getText();
		
		int project_id = Integer.parseInt(input);
		if((Issues) session.get(Issues.class, project_id) != null)
		{
			update_issue = (Issues) session.get(Issues.class, project_id);
			update_issue.setProject_title(projectTitle.getText());
			update_issue.setIssue_description(issueDescription.getText());
		}
		else
		{
			error = true;
			
		}
		
		if(error)
		{
			messageBar.setText("Entry not found!");
		}
		else
		{
			messageBar.setText("Updated!");
		}
		
		
		
		session.update(update_issue);
	
		

		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
}
