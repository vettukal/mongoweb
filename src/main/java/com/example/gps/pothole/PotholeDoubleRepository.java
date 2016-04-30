package com.example.gps.pothole;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "potholedouble")
public interface PotholeDoubleRepository extends MongoRepository<PotholeDouble, String> {
	
	List<PotholeDouble> findByLattitudeBetweenAndLongitudeBetween(double latt1,double latt2,double longi1,double longi2);
	

}