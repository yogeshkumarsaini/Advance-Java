package com.ibm.servlet_simple_demo_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.servlet_simple_demo_project.Connection.StudentConnection;
import com.ibm.servlet_simple_demo_project.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	public Student saveStudentDao(Student student) {

		String insertQueryStudent = "insert into studentdetails values(?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(insertQueryStudent);

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			ps.setString(5, student.getGender());

			ps.execute();

			return student;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Student> getAllDetailsDao() {
		String selectQuery = "Select * from studentdetails";

		try {
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ResultSet resultSet = ps.executeQuery();
			List<Student> students = new ArrayList<Student>();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");
				String gender = resultSet.getString("gender");

				Student student = new Student(id, name, email, phone, gender);
				students.add(student);

			}
			return students;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Student getStudentByIdDao(int id1) {

		String displayQuery = "select * from studentdetails where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(displayQuery);
			ps.setInt(1, id1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				String gender = rs.getString("gender");
				Student stu = new Student(id, name, email, phone, gender);
				return stu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deleteStudentByIdDao(int id) {

		String deleteQuery = "delete from studentdetails where id=?";

		try {

			PreparedStatement ps = connection.prepareStatement(deleteQuery);

			ps.setInt(1, id);

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateStudentData(Student stu) {

		String updateQuery = "update studentdetails set name=?, email=?, phone=?, gender=? where id=?";
		try {

			PreparedStatement ps = connection.prepareStatement(updateQuery);

			ps.setInt(5, stu.getId());
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getEmail());
			ps.setLong(3, stu.getPhone());
			ps.setString(4, stu.getGender());

			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
