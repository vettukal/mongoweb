package com.example;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);
    
    List<Customer> findByLastNameAndFaculty(String lastName, String faculty);
    
    List<Customer> findByLastNameAndFacultyAndQuizidAndSubject(String lastName, String faculty, String quizid, String subject);
}
