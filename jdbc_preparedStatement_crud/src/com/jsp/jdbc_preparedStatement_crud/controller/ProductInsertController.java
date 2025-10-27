package com.jsp.jdbc_preparedStatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 
 * @author yogesh
 *
 *
 */
public class ProductInsertController {

	public static void main(String[] args) {
		Connection connection = null;

		try {
			// Step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step-2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "Saini@1085";

			connection = DriverManager.getConnection(url, user, pass);

			String insertQuery = "insert into product values(?,?,?,?)";

			// Step-3 Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, 101);
			preparedStatement.setString(2, "Paper");
			preparedStatement.setDouble(3, 240);
			preparedStatement.setString(4, "White");

			preparedStatement.execute();
			
			

			// Step-4 executeQuery

		} catch (ClassNotFoundException | SQLException e) {
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