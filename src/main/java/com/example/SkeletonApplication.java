package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pcsma.midsem.SpringMongoConfig;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.example" })
public class SkeletonApplication extends RepositoryRestMvcConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(SkeletonApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(SkeletonApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		
		return (args) -> {
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
			MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

			// Case1 - insert a user, put entity as collection name
			System.out.println("Case 1...");
			
			
			
			
			
			
			
			
			
			
			// save a couple of customers
			//repository.save(new Customer("Jack", "Bauer"));
			//repository.save(new Customer("Chloe", "O'Brian"));
			//repository.save(new Customer("Kim", "Bauer"));
			//repository.save(new Customer("David", "Palmer"));
			//repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			//for (Customer customer : repository.findAll()) 
			{
				//log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
			//Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			//log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			//for (Customer bauer : repository.findByLastName("Bauer")) 
			{
				//log.info(bauer.toString());
			}
            log.info("");
		};
	}
	
	
	
//	@Override
//	public ObjectMapper halObjectMapper(){
//		return new ResourcesMapper();
//	}
}
