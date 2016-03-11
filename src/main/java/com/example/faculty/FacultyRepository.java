package com.example.faculty;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "faculty")
public interface FacultyRepository extends MongoRepository<Faculty, String> {

	List<Faculty> findByName(@Param("name") String name);
	List<Faculty> findByEMail(@Param("eMail") String eMail);
	
}