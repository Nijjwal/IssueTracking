package com.nijjwal.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "Project_Issues")
public class Issues {

	//Properties
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int project_id;
	
	@Column(name="Project_Title", nullable=false)
	private String project_title;
	
	@Column(name="Issue_Description", nullable=false)
	private String issue_description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Issue_Entered_On", nullable=false)
	private Date issue_entered_on;
	
	
	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_title() {
		return project_title;
	}

	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}

	public String getIssue_description() {
		return issue_description;
	}

	public void setIssue_description(String issue_description) {
		this.issue_description = issue_description;
	}

	public Date getIssue_entered_on() {
		return issue_entered_on;
	}

	public void setIssue_entered_on(Date issue_entered_on) {
		this.issue_entered_on = issue_entered_on;
	}
	
	
}
