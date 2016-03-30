package com.example.faculty;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "faculty")
public class Faculty 
{
	@Id private String id;
	private String name ;
	private String eMail ;
	private String password ;
	private List<String> subjectlist ;
	
	public List<String> getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(List<String> subjectlist) {
		this.subjectlist = subjectlist;
	}

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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
