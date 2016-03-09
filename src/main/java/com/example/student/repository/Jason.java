package com.example.student.repository;



import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface Jason {
	@POST("/hellosave")
	public Student hellosave(@Body Student v);
	
	@GET("/hellosave")
	public List<Student> hellosave();
}
