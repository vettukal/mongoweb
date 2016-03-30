package com.example.faculty.signup;



public class SecondPage {
	private static SecondPage instance;
	private SecondPage(){}
	
	public static SecondPage getInstance(){
		if(instance==null){
			instance = new SecondPage();
		}
		return instance;
	}
	
	private String firstName;
	private String lastName;
	//private String number;
	private String email;
	String password;
	private String password2;
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	

}
