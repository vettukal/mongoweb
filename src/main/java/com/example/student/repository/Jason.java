package com.example.student.repository;



import retrofit.http.Body;
import retrofit.http.POST;

public interface Jason {
	@POST("/hellosave")
	public Student hellosave(@Body Student v);
}
