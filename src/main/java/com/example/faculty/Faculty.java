package com.example.faculty;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "faculty")
public class Faculty 
{
	@Id private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String name ;
	private String eMail ;
	private String password ;
	
	public Faculty(){
		
	}
	
	public Faculty(String name, String eMail, String password) 
	{
		setName(name);
		seteMail(name);
		setPassword(password);
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String geteMail() 
	{
		return eMail;
	}

	public void seteMail(String eMail) 
	{
		this.eMail = eMail;
	}
	
	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
