package com.pcsma.midsem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;



public class App 
{

//	public static void main(String[] args)
//	{
//		
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//		MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
//
//		// Case1 - insert a user, put entity as collection name
//		System.out.println("Case 1...");
//		
//		User userA = new User();
//		userA.setName("abc");
//		userA.setAge(10);
//		
//		mongoOperation.save(userA);
//
//		// find
//		
//		User userA1 = mongoOperation.findOne(new Query(Criteria.where("name").is("abc")), User.class);
//		System.out.println(userA1);
//
//		// Case2 - insert a user, put entity as collection name
//		System.out.println("Case 2...");
//		
//		User userB = new User();
//		userB.setName("def");
//		userB.setAge(20);
//		
//		mongoOperation.save(userB);
//
//		// find
//		User userB1 = mongoOperation.findOne(new Query(Criteria.where("age").is(20)), User.class);
//		System.out.println(userB1);
//
//		// Case3 - insert a list of users
//		System.out.println("Case 3...");
//		
//		User userC = new User();
//		userC.setName("amit");
//		userC.setAge(65);
//		
//		User userD = new User();
//		userD.setName("rohit");
//		userD.setAge(25);
//		
//		User userE = new User();
//		userE.setName("kunal");
//		userE.setAge(32);
//		
//		List<User> userList = new ArrayList<User>();
//		userList.add(userC);
//		userList.add(userD);
//		userList.add(userE);
//		mongoOperation.insert(userList, User.class);
//
//		// find
//		List<User> users = mongoOperation.find(new Query(Criteria.where("name").is("amit")),User.class);
//		
//
//		for (User temp : users) 
//		{
//			System.out.println(temp);
//		}
//		
//		SpringApplication.run(App.class, args);
//	}

}