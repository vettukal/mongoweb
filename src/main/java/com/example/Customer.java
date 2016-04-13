package com.example;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "custweb")
public class Customer 
{
	@Id private String id;
	private String firstName;
    private String quizid;
    private String subject;
    private String lastName;
	private String faculty;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getQuizid() {
		return quizid;
	}


	public void setQuizid(String quizid) {
		this.quizid = quizid;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFaculty() {
		return faculty;
	}


	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}


	public Customer() {}


	public Customer(String firstName, String lastName, String faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
    }
    
    public Customer(String firstName, String lastName, String faculty,String quizid,String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.quizid = quizid;
        this.subject = subject;
    }
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
