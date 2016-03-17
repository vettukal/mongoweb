package com.example.android;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.ServerInfo;
import com.example.student.repository.Jason;
import com.example.student.repository.Student;


import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class HelloSaveTest {
	
	private static final String LOCATION_SERVER = "http://localhost:80";
	private static Jason jsoncontroll = new RestAdapter.Builder()
			.setEndpoint(ServerInfo.SEVER_URL)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(Jason.class);
	
	@Test
	public void testVideoAddAndList() throws Exception {
		Student studentA = new Student();
		studentA.setFirstName("vincent");
		studentA.setLastName("testing again.");
		studentA.setEmail("vincent@gmail.com");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("pcsma");
		list.add("ml");
		studentA.setSubjects(list);
		studentA.setRollno("mt14030");
		
		
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
