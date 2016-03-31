package com.example.gps;

import com.example.quiz.repository.QuizSubmission;

import retrofit.http.Body;
import retrofit.http.POST;

public interface GmobileSvc {
	@POST("/submitgmobile")
	public QuizSubmission submitGmobile(@Body Gmobile mobile);
	
}