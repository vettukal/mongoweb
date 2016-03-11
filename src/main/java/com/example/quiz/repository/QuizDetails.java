package com.example.quiz.repository;




import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quizdetails")
public class QuizDetails 
{
	@Id private String id;
	
	@Column(unique=true)
	private Integer quizId;
	private Long creationTime;
	private Long endingTime;
	private Integer maxTime;
	private String question;
	private String subject;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public Long getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(Long endingTime) {
		this.endingTime = endingTime;
	}

	public Integer getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Integer maxTime) {
		this.maxTime = maxTime;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuizDetails(){
		
	}
	
	
}