package com.example.gps.inter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "intergps")
public interface InterGPSRepository extends MongoRepository<InterGPS, String> {

	

}