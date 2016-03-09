package com.example.retrofit;

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
		studentA.setFirstName("junit1");
		studentA.setLastName("2dfred");
		
		jsoncontroll.hellosave(studentA);
	}
}
