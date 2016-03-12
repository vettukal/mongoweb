package com.example.student.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "student")
//@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByLastName(@Param("name") String name);
	List<Student> findByEmail(@Param("name") String name);

}