package com.example.quiz.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.ServerInfo;
import com.example.quiz.controller.QuizSvc;
import com.example.quiz.repository.QuizSubmission;
import com.example.student.repository.Jason;
import com.example.student.repository.Student;


import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class QuizClient {
	
	private static final String LOCATION_SERVER = "http://localhost:80";
	private static QuizSvc quizControl = new RestAdapter.Builder()
			.setEndpoint(ServerInfo.SEVER_URL)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(QuizSvc.class);
	
	@Test
	public void testVideoAddAndList() throws Exception {
		//com.example.quiz.repository.QuizDetails qd = quizControl.greetingForm("vince@gmail.com");
		//if(qd==null)
		//{
			// there are no active quize
			//return;
		//}
		//System.out.println("quizsubmitTest: "+qd.getQuizId()+" : "+qd.getQuestion());
		
		//Integer quizId = qd.getQuizId();
		//String subject = qd.getSubject();
		
		QuizSubmission qs = new QuizSubmission();
		qs.setQuizId(2);
		qs.setSubject("maths");
		qs.setEmail("newton@gmail.com");
		qs.setOption("a");
		qs.setRollNo("Mt14040");
		
		System.out.println(quizControl.submitQuiz(qs));
		
	}
	
	
}