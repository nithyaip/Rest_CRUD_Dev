package com.java.rest.Rest_CRUD.model;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private String fristName ;
	private String lastName;
	
	public Employee(){
		
	}
	public Employee(String fristName, String lastName) {
		this.fristName = fristName;
		this.lastName = lastName;
	}
	
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
