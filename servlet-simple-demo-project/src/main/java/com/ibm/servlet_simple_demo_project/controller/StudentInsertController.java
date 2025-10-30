package com.ibm.servlet_simple_demo_project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ibm.servlet_simple_demo_project.Service.StudentService;
import com.ibm.servlet_simple_demo_project.dto.Student;

public class StudentInsertController implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		StudentService service = new StudentService();

		int id = Integer.parseInt(req.getParameter("studentId"));
		String name = req.getParameter("studentName");
		long phone = Long.parseLong(req.getParameter("studentPhone"));
		String email = req.getParameter("studentEmail");
		String gender = req.getParameter("gender");

		PrintWriter printWriter = res.getWriter();

		Student student=service.saveStudentService(new Student(id, name, email, phone, gender));
		

		if (student != null) {

			printWriter.write("<html><body>");
			printWriter.write("<h3 style='color:green'>STUDENT is Registered<h3>");
			printWriter.write("<h3>STUDENT-DETAILS<h3>");
			printWriter.write("<h3>" + id + "<h3>");
			printWriter.write("<h3>" + name + "<h3>");
			printWriter.write("<h3>" + phone + "<h3>");
			printWriter.write("<h3>" + email + "<h3>");
			printWriter.write("<h3>" + gender + "<h3>");

			printWriter.write("</body></html>");

		} else {
			printWriter.write("<html><body>");

			printWriter.write("<h3 style='color:red'>STUDENT is not Registered<h3>");
			printWriter.write("</body></html>");
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("student-registration.jsp");
		dispatcher.include(req, res);

	}

	@Override

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
