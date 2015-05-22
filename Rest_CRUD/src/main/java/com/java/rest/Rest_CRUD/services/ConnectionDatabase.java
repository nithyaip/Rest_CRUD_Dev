package com.java.rest.Rest_CRUD.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.rest.Rest_CRUD.model.Employee;

public class ConnectionDatabase {

	String username= "hr";
	String password = "hr123";
	Statement stmt = null;
	Connection con ; 
	String host = "jdbc:oracle:thin:@hr.cwjgdp1wxdy2.us-west-1.rds.amazonaws.com:1521:orcl";


	public ConnectionDatabase() {


	}


	public Connection getCon() {
		if(con==null){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver loaded!");		
				con = DriverManager.getConnection( host, username, password );
				setCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		else
			return con;
	}


	public void setCon(Connection con) {
		this.con = con;
	}


	//Get Values
	public List<Employee> getValues(){
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<Employee>();

		try{
			Connection c  = getCon();
			stmt = c.createStatement();
			String sql;

			//			sql = "select FIRST_NAME,LAST_NAME from EMPLOYEES where EMPLOYEE_ID = 504";

			sql = "select FRISTNAME,LASTNAME from EMPLOYEE ";
			rs = stmt.executeQuery(sql);
			while(rs.next()){

				Employee emp = new Employee();

				String fN = rs.getString("FRISTNAME") ;
				String lN = rs.getString("LASTNAME");

				emp.setFristName(fN);
				emp.setLastName(lN);

				empList.add(emp);

			}

			rs.close();
			stmt.close();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;

	}

	//Post Values
	public String addValues(Employee e){

		Statement stmt = null;
		/*Statement sel = null;
		ResultSet rs = null;*/


		try{
			Connection c  = getCon();
			stmt = c.createStatement();
			String insert;
			insert = "insert into employee values('" + e.getFristName() + "','"+ e.getLastName() +"')";


			stmt.executeQuery(insert);		

			//rs.close();
			stmt.close();
			//sel.close();
			con.close();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return "Inserted New entry ";

	}

	//Delete Values
	public String deleteValues(String fn) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		try{
			Connection c  = getCon();
			stmt = c.createStatement();
			String delete="DELETE FROM employee WHERE lastname = '" + fn +"'";
			stmt.executeUpdate(delete);		


			stmt.close();
			con.close();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return "Row Deleted ";
	}

	//updateValues
	public String updateValues(String fn, Employee emp) {



		Statement stmt = null;
		try{
			Connection c  = getCon();
			stmt = c.createStatement();
			String update= "UPDATE employee SET lastname = '"+ fn + "' WHERE fristname = '" + emp.getFristName() +"'";
			//String delete="DELETE FROM employee WHERE lastname = '" + fn +"'";
			stmt.executeUpdate(update);		


			stmt.close();
			con.close();
		}
		catch (SQLException s) {
			s.printStackTrace();
		}
		return "Row Updated ";
	}


}
