package com.example.quiz.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "quizsubmission")
public interface QuizSubmissionRepository extends MongoRepository<QuizSubmission, String> {

	List<QuizDetails> findByQuizId(@Param("quizid") Integer quizId);

}