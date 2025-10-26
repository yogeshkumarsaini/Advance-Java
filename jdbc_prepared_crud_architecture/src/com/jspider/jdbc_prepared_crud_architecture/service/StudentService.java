package com.jspider.jdbc_prepared_crud_architecture.service;

import java.util.List;

import com.jspider.jdbc_prepared_crud_architecture.dao.StudentDao;
import com.jspider.jdbc_prepared_crud_architecture.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();

	public Student saveStudentService(Student student) {
		int id = student.getId();
		if (id < 1000) {
			return dao.saveStudentDao(student);
		} else {
			System.out.println("Please pass id with 3 digit or less than");
			return null;
		}
	}

	/*
	 * adsgfdas
	 * 
	 * 
	 */
	public Student getStudentByIdService(int studentId) {
		return dao.getStudentByIdDao(studentId);
	}

	public List<Student> getAllStudentService() {
		return dao.getAllStudentDao();
	}

	public int updateStudentNameByIdService(int id, String name) {
		return dao.updateStudentNameByIdDao(id, name);
	}
}
