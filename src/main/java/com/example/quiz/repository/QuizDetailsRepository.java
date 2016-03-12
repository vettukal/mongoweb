package com.example.quiz.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "quizdetails")
public interface QuizDetailsRepository extends MongoRepository<QuizDetails, String> {

	List<QuizDetails> findByQuizId(@Param("quizid") Integer quizId);
	List<QuizDetails> findByEndingTimeGreaterThan(@Param("time") Long presentTime);
	List<QuizDetails> findByQuizIdAndSubject(Integer quizId, String subject);
}