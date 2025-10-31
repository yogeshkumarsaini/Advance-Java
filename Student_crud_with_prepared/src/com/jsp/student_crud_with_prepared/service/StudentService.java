package com.jsp.student_crud_with_prepared.service;

import com.jsp.student_crud_with_prepared.dao.StudentDao;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentService {
	
	StudentDao studentDao=new StudentDao();
	/*
	 * insertMethod for student
	 */
	public Student insertStudentService(Student student) {
		
		if(student.getStudentId()<=9999) {
			Student student2= studentDao.insertStudentService(student);
			return student2;
		}
		else {
			System.err.println("Please pass your id with 4 digits or less than it");
		}
//		if(student.getStudentPhone()<=9999999999999l) {
//			Student student2 = studentDao.insertStudentService(student);
//			return student2;
//			
//		}
//		else {
//			System.err.println("PLease pass your phone with 13 digits 0r less than it");
//		}
		
		return null;
		
	}
}
