package com.ibm.servlet_simple_demo_project.Service;

import java.util.List;

import com.ibm.servlet_simple_demo_project.dao.StudentDao;
import com.ibm.servlet_simple_demo_project.dto.Student;

public class StudentService {

	StudentDao dao = new StudentDao();

	public Student saveStudentService(Student student) {
		return dao.saveStudentDao(student);
	}

	public List<Student> getAllDetailService() {

		return dao.getAllDetailsDao();
	}
	
	public int deleteStudentByIdService(int id) {
		return dao.deleteStudentByIdDao(id);
	}
	
	public int updateStudentDataService(Student stu) {
		return dao.updateStudentData(stu);
	}

}
