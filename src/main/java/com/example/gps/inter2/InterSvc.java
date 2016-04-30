package com.example.gps.inter2;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.repository.QuizSubmission;

import retrofit.http.Body;
import retrofit.http.POST;

public interface InterSvc {
	@POST("/submitinter2")
	public @ResponseBody InterGPS2 submitInter(@Body InterGPS2 quizsub);
	
	@POST("/submitinterlist2")
	public @ResponseBody List<InterGPS2> submitInterList(@Body List<InterGPS2> quizsublist) ;
	
}