package com.pcsma.midsem;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User 
{		
	private String name;
	private int age;
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
	    this.age = age;
	}
	
	public String toString()
	{
	   StringBuilder builder = new StringBuilder();
	   builder.append(this.getName())
		      .append(", ")
		      .append(this.getAge());
	   return builder.toString();
	}

}