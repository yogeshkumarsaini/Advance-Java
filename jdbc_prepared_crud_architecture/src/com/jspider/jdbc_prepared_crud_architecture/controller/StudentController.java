package com.jspider.jdbc_prepared_crud_architecture.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.jdbc_prepared_crud_architecture.dto.Student;
import com.jspider.jdbc_prepared_crud_architecture.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		StudentService service = new StudentService();

		while (true) {
			System.out.println("1.Insert\n2.getById\n3.Update\n4.Display\nExit");
			System.out.println("Select the option");
			int ch = scanner.nextInt();

			switch (ch) {
			case 1: {
				System.out.println("Enter the Id");
				int id = scanner.nextInt();
				System.out.println("Enter the Name");
				String name = scanner.next();
				System.out.println("Enter the Email");
				String email = scanner.next();
				System.out.println("Enter the Phone No.");
				long phone = scanner.nextLong();

				Student student = new Student(id, name, email, phone);

				Student st = service.saveStudentService(student);

				if (st != null) {
					System.out.println("Data is stored");
				} else {
					System.out.println("Data is not stored");
				}

			}
				break;
			case 2: {
				System.out.println("Enter the Id to display");
				int id = scanner.nextInt();

				Student student = service.getStudentByIdService(id);

				if (student != null) {
					System.out.println(student);
				} else {
					System.err.println("given id is not found or check with sql Query");
				}

			}
				break;
			case 3: {

				System.out.println("Enter the student id  to update name");
				int id = scanner.nextInt();
				System.out.println("Enter new student name");
				String name = scanner.next();

				int a = service.updateStudentNameByIdService(id, name);

				if (a==1) {
					System.out.println("Data is Updated");

				} else {
					System.out.println("Given id is not found or check with sql Query");
				}

			}
				break;
			case 4: {
				List<Student> students = service.getAllStudentService();

				if (students != null) {
					for (Student student : students) {
						System.out.println(student);
					}
				} else {
					System.out.println("there is no data available in database........");
				}

			}
				break;

			}
		}
	}
}
