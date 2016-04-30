package com.example.gps.inter2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "intergps2")
public interface InterGPSRepository2 extends MongoRepository<InterGPS2, String> {

	

}