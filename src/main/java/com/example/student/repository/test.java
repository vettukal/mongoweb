package com.example.student.repository;

import java.util.List;

import com.example.quiz.controller.QuizSvc;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class test {
	private static final String LOCATION_SERVER = "http://localhost:80";
	private static QuizSvc quizControl = new RestAdapter.Builder()
			.setEndpoint(LOCATION_SERVER)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(QuizSvc.class);
	
//	public static void main(String[] args) {
//
//		List<String> sublist = quizControl.getStudSubject("vince@gmail.com");
//		for (String siter : sublist)
//		{
//			System.out.println(siter);
//		}
//		
//		List<String> subjects = quizControl.getSubject("hello");
//		for (String siter : subjects) {
//			System.out.println(siter);
//		}
//
//	}

}
