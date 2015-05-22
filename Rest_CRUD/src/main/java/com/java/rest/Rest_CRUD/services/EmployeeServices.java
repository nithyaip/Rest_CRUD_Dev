package com.java.rest.Rest_CRUD.services;

import java.util.*;

import com.java.rest.Rest_CRUD.model.Employee;



public class EmployeeServices {

	ConnectionDatabase con;


	public EmployeeServices(){


	}

	public List<Employee> getName(){

		con = new ConnectionDatabase();
		return con.getValues();


	}


	public String addEmployee(Employee emp){


		con = new ConnectionDatabase();

		return con.addValues(emp);


	}

	
	public String updateEmployee(String fn ,Employee emp){


		con = new ConnectionDatabase();

		return con.updateValues(fn,emp);

	}

	
	public String deleteEmployee(String fn ){

		con = new ConnectionDatabase();

		return con.deleteValues(fn);
	}


	
	
	
	
	/*public List<Employee> callToDB(){
	List<Employee> e = new ArrayList<Employee>();
	Employee e1 = new Employee("Innova", "path");
	Employee e2 = new Employee("Innova1", "path2");
	e.add(e1);
	e.add(e2);
	return e;

}

public String getLastName(String fristName){

	Employee e1 = new Employee("Innova", "path");
	Employee e2 = new Employee("Innova1", "path2");	
	if(fristName.equals(e1.getFristName()))
		return "Hey " +fristName + ", your Last Name is " + e1.getLastName();
	if(fristName.equals(e2.getFristName()))
		return "Hey " +fristName + " , your Last Name is " + e2.getLastName();
	return "Hey  "+ fristName +"  , Sorry !!! No match found ";

}*/

}
