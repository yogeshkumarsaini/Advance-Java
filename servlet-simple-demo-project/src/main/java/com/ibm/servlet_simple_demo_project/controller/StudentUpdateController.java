package com.ibm.servlet_simple_demo_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.servlet_simple_demo_project.Service.StudentService;
import com.ibm.servlet_simple_demo_project.dto.Student;

@WebServlet( value="/studentUpdate")
public class StudentUpdateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		StudentService service = new StudentService();

		int id = Integer.parseInt(req.getParameter("studentId"));
		String name = req.getParameter("studentName");
		long phone = Long.parseLong(req.getParameter("studentPhone"));
		String email = req.getParameter("studentEmail");
		String gender = req.getParameter("gender");
		
		Student st = new Student(id,name,email,phone,gender);
		
		service.updateStudentDataService(st);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}
}
