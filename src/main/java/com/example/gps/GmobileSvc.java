package com.example.gps;

import java.util.List;

import com.example.quiz.repository.QuizSubmission;

import retrofit.http.Body;
import retrofit.http.POST;

public interface GmobileSvc {
	@POST("/submitgmobile")
	public Gmobile submitGmobile(@Body Gmobile mobile);
	
	@POST("/submitgmobilelist")
	public String submitGmobileList(@Body List<Gmobile> mobile);
	
}