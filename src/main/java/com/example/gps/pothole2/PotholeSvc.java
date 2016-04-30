package com.example.gps.pothole2;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.gps.inter2.InterGPS2;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface PotholeSvc {
	
	
	@GET("/getpothole2")
	public @ResponseBody List<Pothole2> getpothole();
	
}