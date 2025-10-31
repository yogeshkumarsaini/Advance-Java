package com.jsp.student_crud_with_prepared.controller;

import java.util.Scanner;

import com.jsp.student_crud_with_prepared.dto.Student;
import com.jsp.student_crud_with_prepared.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student student = null;
		StudentService studentService = new StudentService();
		

		
		
		System.out.println("1. Insert\n2.Update");
		System.out.println("Enter your option");
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter Student id");
			int id=sc.nextInt();
			System.out.println("Enter Student name");
			String name=sc.next();
			System.out.println("Enter Student email");
			String email=sc.next();
			System.out.println("Enter Student phone");
			long phone=sc.nextLong();
			
			student = new Student(id,name,email,phone);
			studentService.insertStudentService(student);
		}
		break;
		case 2: {

		}
		break;
		}
		

	}
}
