package com.tcs.jdbc_simple_project.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class StudentDisplayController {
	static Connection connection = null;

	public static void main(String[] args) {

		try {
			// Step-1 Load/Register Driver
			// Register Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step-2 Create connection
			String url = "jdbc:mysql://localhost:3306/students";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			// Step-3 Create Statement
			Statement statement = connection.createStatement();

			// Step-4 ExecuteQuery
			String displayAllStudentQuery = "SELECT * FROM studentInfo";

			ResultSet resultSet = statement.executeQuery(displayAllStudentQuery);

			 while(resultSet.next()) {
			int id = resultSet.getInt("id");

			String name = resultSet.getString("name");

			String email = resultSet.getString("email");

			long phone = resultSet.getLong("phone");

			System.out.println("Student id is " + id);
			System.out.println("Student Name is " + name);
			System.out.println("Student Email is " + email);
			System.out.println("Student Phone is " + phone);
			System.out.println("========================");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Step-5 Close Connection
		finally {

			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
