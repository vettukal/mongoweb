package com.example.gps;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "gmobile")
public interface GmobileRepository extends MongoRepository<Gmobile, String> {

	

}