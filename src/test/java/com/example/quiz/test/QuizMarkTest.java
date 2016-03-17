package com.example.quiz.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.ServerInfo;
import com.example.quiz.controller.QuizSvc;
import com.example.quiz.repository.QuizMarks;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

public class QuizMarkTest {
	
	private static final String LOCATION_SERVER = "http://54.209.192.114/:80";
	private static QuizSvc quizControl = new RestAdapter.Builder()
			.setEndpoint(ServerInfo.SEVER_URL)
			.setLogLevel(LogLevel.FULL)
			.build()
			.create(QuizSvc.class);
	
	@Test
	public void testMarkFetching() throws Exception {
		List<QuizMarks> qmlist = quizControl.getMarks("pcsma", "gcc");
		for (QuizMarks quizMarks : qmlist) {
			System.out.println(quizMarks.getMarks());
		}
		
		String[] labels = {"A","B","C","D"};
		for (int i = 0; i < labels.length; i++) {
			labels[i] = "\""+labels[i]+"\"";
		}
		System.out.println(Arrays.toString(labels));
	}

}
