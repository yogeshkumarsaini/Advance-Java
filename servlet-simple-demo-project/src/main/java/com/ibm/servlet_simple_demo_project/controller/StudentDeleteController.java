package com.ibm.servlet_simple_demo_project.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ibm.servlet_simple_demo_project.Service.StudentService;

public class StudentDeleteController  extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		StudentService service = new StudentService();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		service.deleteStudentByIdService(id);
		
		req.getRequestDispatcher("display.jsp").forward(req, res);
		
	}
	
}
