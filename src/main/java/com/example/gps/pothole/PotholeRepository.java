package com.example.gps.pothole;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "pothole")
public interface PotholeRepository extends MongoRepository<Pothole, String> {


}