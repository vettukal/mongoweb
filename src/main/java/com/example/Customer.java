package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String quizid;
    private String subject;
    public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String lastName;
	
	private String faculty;

    public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
