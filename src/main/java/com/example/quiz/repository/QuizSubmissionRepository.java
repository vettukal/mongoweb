package com.example.quiz.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "quizsubmission")
public interface QuizSubmissionRepository extends MongoRepository<QuizSubmission, String> {

	List<QuizSubmission> findByQuizId(@Param("quizid") Integer quizId);
	List<QuizSubmission> findByQuizIdAndSubject(@Param("quizid") Integer quizid
			,@Param("subject") String subject);
	
	// @Query("select u.quizId from QuizSubmission u ")
	//List<Integer> getQuizId();
	
	List<QuizSubmission> findByQuizIdAndSubjectAndEmail(@Param("quizid") Integer quizid
			,@Param("subject") String subject,@Param("email") String email);
}