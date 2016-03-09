package com.example.android;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.student.repository.Jason;
import com.example.student.repository.Student;


import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class HelloSaveTest {
	
	private static final String LOCATION_SERVER = "http://localhost:80";
	private static Jason jsoncontroll = new RestAdapter.Builder()
			.setEndpoint(LOCATION_SERVER)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(Jason.class);
	
	@Test
	public void testVideoAddAndList() throws Exception {
		Student studentA = new Student();
		studentA.setFirstName("junitRollnull");
		studentA.setLastName("list is done.");
		studentA.setEmail("vince@gmail.com");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("pcsma");
		list.add("ml");
		studentA.setSubjects(list);
		studentA.setRollno("helloroll");
		
		
		System.out.println(jsoncontroll.hellosave(studentA));
		
		List<Student> studlist = jsoncontroll.hellosave(); 
		String out = studlist.toString();
		System.out.println();
	}
	
	public Student saveObject(String firstName, String lastName, 
			String email, String rollno, List<String> subjects){
		Student studentA = new Student();
		
		
		studentA.setFirstName(firstName);
		studentA.setLastName(lastName);
		studentA.setEmail(email);
		
		
		studentA.setSubjects(subjects);
		studentA.setRollno(rollno);
		
		Student result = jsoncontroll.hellosave(studentA);
		return result;
	}
	
}
