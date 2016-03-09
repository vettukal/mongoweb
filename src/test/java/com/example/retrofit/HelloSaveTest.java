package com.example.retrofit;

import java.util.List;

import org.junit.Test;

import com.example.student.repository.JSONController;
import com.example.student.repository.Jason;
import com.example.student.repository.Student;


import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class HelloSaveTest {

	private Jason jsoncontroll = new RestAdapter.Builder()
			.setEndpoint("http://localhost:80")
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(Jason.class);
	
	@Test
	public void testVideoAddAndList() throws Exception {
		Student studentA = new Student();
		studentA.setFirstName("junit23");
		studentA.setLastName("first green");
		
		jsoncontroll.hellosave(studentA);
		
		List<Student> studlist = jsoncontroll.hellosave(); 
		String out = studlist.toString();
		System.out.println();
	}
}
