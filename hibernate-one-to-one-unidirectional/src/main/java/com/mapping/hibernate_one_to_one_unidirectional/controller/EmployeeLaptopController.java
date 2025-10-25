package com.mapping.hibernate_one_to_one_unidirectional.controller;

import java.util.List;
import java.util.Scanner;

import com.mapping.hibernate_one_to_one_unidirectional.Service.EmployeeLaptopService;
import com.mapping.hibernate_one_to_one_unidirectional.dao.EmployeeLaptopDao;
import com.mapping.hibernate_one_to_one_unidirectional.dto.Employee;
import com.mapping.hibernate_one_to_one_unidirectional.dto.Laptop;

public class EmployeeLaptopController {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
			EmployeeLaptopService laptopService=new EmployeeLaptopService();
			
			while (true) {
				System.out.println("Enter the optipn");
				System.out.println("1.Insert\n2.GetbyId\n3.Delete\n4.DisplayAll");
				int ch = sc.nextInt();
				switch (ch) {

				case 1: {
			
					Laptop laptop =new Laptop(111, "Samasung", "White", 45000);			 
					Employee employee=new Employee(123,"Yogesh","yogesh@ibm.com",8430151085l);
					laptopService.saveEmployeeLaptopService(employee, laptop);
					break;
				}
				case 2:{
						Employee employee=	laptopService.getLaptopByEmployeeIdService(123);
						if(employee!=null) {
							System.out.println(employee);
							Laptop laptop=employee.getLaptop();
						
							if(laptop!=null) {
								System.out.println(laptop);
							}
					
						}
						break;
				}
			 
				case 3:{
					EmployeeLaptopDao dao=new EmployeeLaptopDao();
					dao.deleteLaptopAndEmployeeByEmployeeIdDao(123);
					
					break;
				}
				case 4:{
					EmployeeLaptopDao dao =new EmployeeLaptopDao();
					List<Employee> employees =dao.getAllEmployeeAndLaptopDetails();
					
					if(!employees.isEmpty()) {
						System.out.println("Employee=Details");
						for(Employee employee:employees) {
							System.out.println(employee);
							Laptop laptop=employee.getLaptop();
							if(laptop!=null) {
								System.out.println(laptop);
							}
						}
					}
					
					break;
				}
				default:
					break;
		
			}
		
		}
	}
	
}
