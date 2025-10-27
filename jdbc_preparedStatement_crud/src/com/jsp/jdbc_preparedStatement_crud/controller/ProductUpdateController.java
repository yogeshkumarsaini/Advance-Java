package com.jsp.jdbc_preparedStatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateController {
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
			String updateColorQuery = "update product set productcolor=? where productid=?";

			PreparedStatement preparedStatement = connection.prepareStatement(updateColorQuery);

			preparedStatement.setString(1, "white");
			preparedStatement.setInt(2, 100);

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Data is Updated");
			} else {
				System.out.println("Given data is not update");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
