package com.example.gps.inter2;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gps.pothole2.Pothole2;
import com.example.gps.pothole2.PotholeDouble2;
import com.example.quiz.repository.QuizSubmission;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface InterSvc {
	@POST("/submitinter2")
	public @ResponseBody InterGPS2 submitInter(@Body InterGPS2 quizsub);
	
	@POST("/submitinterlist2")
	public @ResponseBody String submitInterList(@Body List<InterGPS2> quizsublist) ;
	
	@GET("/getpothole2")
	public @ResponseBody List<Pothole2> getpothole();
	
	@GET("/getpotholedouble2")
    public @ResponseBody List<PotholeDouble2> getpotholedouble();
	
	@GET("/getpotholelatlngdec")
    public @ResponseBody List<PotholeDouble2> getpotholelatlngdec(@Query("lattitude") Double latt, @Query("longitude") Double longi,@Query("dec") Double dec);
	
}