package com.example.gps.pothole2;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource( path = "potholedouble2")
public interface PotholeDoubleRepository2 extends MongoRepository<PotholeDouble2, String> {
	
	List<PotholeDouble2> findByLattitudeBetweenAndLongitudeBetween(double latt1,double latt2,double longi1,double longi2);
	

}