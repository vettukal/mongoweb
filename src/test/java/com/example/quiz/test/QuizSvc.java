package com.example.quiz.test;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.repository.QuizDetails;
import com.example.quiz.repository.QuizSubmission;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface QuizSvc {
	@POST("/submitquiz")
	public QuizSubmission submitQuiz(@Body QuizSubmission quizsub);
	
	@GET("/activequiz")
	public QuizDetails greetingForm(@Query("email") String email);
}
