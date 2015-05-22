package com.java.rest.Rest_CRUD.resource;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.java.rest.Rest_CRUD.model.Employee;
import com.java.rest.Rest_CRUD.services.EmployeeServices;


@Path("/Employee")
public class EmployeeResource {

	EmployeeServices es = new EmployeeServices();

	
	
	//To Fetch the all record  
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmpNameInXML(){

		return es.getName();
	}

	

	
	
	
	
	
	/*	
	 * To add/post an Employee Object and 
	 * consuming the Xml content in the code and 
	 * returning back the newly added Xml along with the some 
	 * enteries appeneded via code ( Like DB) .
	 */ 

	@POST
	@Consumes(MediaType.APPLICATION_JSON)//Accepts the content that we post in the url as an XML form
	@Produces(MediaType.TEXT_PLAIN)//Produces the content that we return in an XML form
	public String postMethod(Employee emp){

		return es.addEmployee(emp) ;
	}
	
	
	
	
	
	
	/*
	 * Update the particular employee object.
	 * By checking the path parameter entered ,update the employee object
	 * with the one that is being consumed . 
	 * Returns back the whole list along the updated object.
	 */
	@PUT
	@Path("/{fristName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String putMethod(@PathParam("fristName")String fn , Employee emp){

		return es.updateEmployee(fn.toString(),emp) ;
	}
	
	
	
	
	
	
	

	/*
	 * Delete the particular which we are passing as an param id in the url 
	 * here in this eg its FristName
	 */

	@DELETE
	@Path("/{fristName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMethod(@PathParam("fristName")String fn){

		return es.deleteEmployee(fn.toString()) ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*//To Fetch the particular record by passing the input in the url 
	@GET
	@Path("/{fristName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getEmployeeLastName(@PathParam("fristName")String fn){

		return es.getLastName(fn.toString());
	}*/
	
	/*  
	 * To post the String in the url and 
		consuming the content in the code and 
		returning back the posted string along with some String appeneded . 
		
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String postString(String messagePosted){

		return "Hey Post operation Called and message posted is , " + messagePosted ;
	}
	*/
}
