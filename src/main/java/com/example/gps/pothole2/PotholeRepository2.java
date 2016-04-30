package com.example.gps.pothole2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "pothole2")
public interface PotholeRepository2 extends MongoRepository<Pothole2, String> {


}