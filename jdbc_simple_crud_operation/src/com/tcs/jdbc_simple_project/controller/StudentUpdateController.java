package com.tcs.jdbc_simple_project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentUpdateController {

	public static void main(String[] args) {
		System.out.println("Enter the Id");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();

		System.out.println("Enter new email to update");
		String email = scanner.next();
		try {
			// Step-1 load/Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2 Create connection
			String url = "jdbc:mysql://localhost:3306/students";
			String user = "root";
			String pass = "root";

			Connection connection = DriverManager.getConnection(url, user, pass);
			// Step-3 Create Statement
			Statement statement = connection.createStatement();

			// Step-4 ExecuteQuery
			String updateStudentEmailQuery = "update studentInfo set email='" + email + "'WHERE id=" + id;

			int a = statement.executeUpdate(updateStudentEmailQuery);
			if (a == 1) {
				System.out.println("----Data____Upadted-------");
			} else {
				System.out.println("Given id is not present ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
