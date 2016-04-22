package com.example.quiz.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.repository.QuizDetails;


import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface QuizSvc {
//	@POST("/submitquiz")
//	public QuizSubmission submitQuiz(@Body QuizSubmission quizsub);
	
	@GET("/activequiz")
	public QuizDetails greetingForm(@Query("email") String email);
	
//	@GET("/getmarks")
//	public List<QuizMarks> getMarks(@Query("subject") String subject
//			,@Query("email") String email);
	
	@GET("/isdone")
	public Boolean isDone(@Query("email") String email);
	
	@GET("/getaverage")
	public Float getDone(@Query("subject") String subject);
	
	@GET("/getsubjects")
	public List<String> getSubject(@Query("subject") String subject);
	
	
	@GET("/getstudsubjects")
	public List<String> getStudSubject(@Query("subject") String subject);

	@GET("/getaverage2done")
	public List<String> getDone2(@Query("subject") String subject);
	

	
}
