package com.wipro.hibernate_jpa_crud_operation.controller;

import java.util.Scanner;

import com.wipro.hibernate_jpa_crud_operation.Service.CompanyService;
import com.wipro.hibernate_jpa_crud_operation.dto.Company;

public class CompanyController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CompanyService companyService = new CompanyService();

		while (true) {
			System.out.println("Enter the optipn");
			System.out.println("1.Insert\n2.GetbyId\n3.Delete\n4.Updtae\n5.DisplayAll");
			int ch = sc.nextInt();
			switch (ch) {

			case 1: {
				Company company = new Company(3, "Wipro", "wipro@gmail.com", "Noida", 5678);
				companyService.saveCompanyService(company);
				break;
			}
			case 2: {
				System.out.println("Enter company id yo display");
				int id = sc.nextInt();
				Company company = companyService.getCompanyByIdService(id);

				if (company != null) {
					System.out.println(company);
				} else {
					System.out.println("Id not found");
				}
				break;
			}
			case 3: {
				System.out.println("Enter company id to delete");
				int id = sc.nextInt();
				boolean b = companyService.deleteCompanyByIdService(id);
				if (b) {
					System.out.println("Data deleted");
				} else {
					System.out.println("id not found");
				}

				break;
			}
			case 4: {
				System.out.println("Enter company id to update company name");
				int id = sc.nextInt();
				System.out.println("Enter the new company name");
				String name = sc.next();
				name = name + sc.nextLine();

				Company company = companyService.updateCompanyByIdService(id, name);
				if (company != null) {
					System.out.println("Data is Updated");
				} else {
					System.out.println("Id not found");
				}
				break;
			}
			case 5: {
				for (Company company : companyService.getAllCompanyDetailsService()) {
					System.out.println(company);
				}
				break;
			}
			case 6: {

				break;
			}
			case 7: {

				break;
			}
			default:
				break;
			}
		}

	}
}
