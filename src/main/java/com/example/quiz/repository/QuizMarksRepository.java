package com.example.quiz.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "quizmarks")
public interface QuizMarksRepository extends MongoRepository<QuizMarks, String> {

	List<QuizMarks> findByQuizId(@Param("quizid") Integer quizId);
	List<QuizMarks> findBySubjectAndEmail(@Param("subject") String subject
			,@Param("email") String email);
	
	List<QuizMarks> findBySubject(@Param("subject") String subject	);

}