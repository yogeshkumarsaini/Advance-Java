package com.jsp.jdbc_preparedStatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDeleteController {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			// Step-1 Load/registered Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "root";

			connection = DriverManager.getConnection(url, user, pass);

			// Step-3 Create Statement
			String deleteQuery ="delete from product where productid=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, 100);
			
			
			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Data is Deleted");
			} else {
				System.out.println("Given data is not deleted");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
}
