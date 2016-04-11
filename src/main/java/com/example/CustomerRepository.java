package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
    List<Customer> findByLastNameAndFaculty(String lastName, String faculty);
    
    List<Customer> findByLastNameAndFacultyAndQuizidAndSubject(String lastName, String faculty, String quizid, String subject);
}
