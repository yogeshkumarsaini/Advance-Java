package com.tcs.jdbc_simple_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsertController {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Step-2 Create Connection
			String url = "jdbc:mysql://localhost:3306/students";
			String user = "root";
			String pass = "root";
			
			connection = DriverManager.getConnection(url, user, pass);
			// Step-3 Create Statement
			Statement statement = connection.createStatement();
		
			
			//Step-4 executeQuery
			String insertStudentQuery = "insert into studentInfo (id,name,email,phone) values (03,'Yogesh','yogesh@gmail.com',8430151085)";
			statement.execute(insertStudentQuery);
			
			System.out.print("-------Data_______Store-----------");
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
			
		}
		// Step-5 Close Connection
		finally {
			
			try {
				connection.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
