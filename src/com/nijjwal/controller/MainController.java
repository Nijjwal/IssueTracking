package com.nijjwal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable{
	
	@FXML
	private Label messageBar;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	public void showGreeting(ActionEvent event)
	{
		System.out.println("You have clicked the New button");
		messageBar.setText("Hello World!");
	}
	
}
