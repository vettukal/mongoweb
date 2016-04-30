package com.example.gps.inter;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.quiz.repository.QuizSubmission;

import retrofit.http.Body;
import retrofit.http.POST;

public interface InterSvc {
	@POST("/submitinter")
	public @ResponseBody InterGPS submitInter(@Body InterGPS quizsub);
	
	@POST("/submitinterlist")
	public @ResponseBody List<InterGPS> submitInterList(@Body List<InterGPS> quizsublist) ;
	
}