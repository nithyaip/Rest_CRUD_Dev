package com.java.rest.Rest_CRUD.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnection {

	public static void main(String[] args) {


		String username= "hr";
		String password = "hr123";
		Statement stmt = null;

		String host = "jdbc:oracle:thin:@hr.cwjgdp1wxdy2.us-west-1.rds.amazonaws.com:1521:orcl";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {

			Connection con = DriverManager.getConnection( host, username, password );
			stmt = con.createStatement();
			String sql;
			sql = "select FIRST_NAME,LAST_NAME from EMPLOYEES where EMPLOYEE_ID = 504";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){

				String fN = rs.getString("FIRST_NAME") ;
				String lN = rs.getString("LAST_NAME");


				System.out.println("Email : " + fN);
				System.out.println("EMPLOYEE_ID : "+ lN);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
