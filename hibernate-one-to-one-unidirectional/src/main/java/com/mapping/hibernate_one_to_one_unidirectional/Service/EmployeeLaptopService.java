package com.mapping.hibernate_one_to_one_unidirectional.Service;

import com.mapping.hibernate_one_to_one_unidirectional.dao.EmployeeLaptopDao;
import com.mapping.hibernate_one_to_one_unidirectional.dto.Employee;
import com.mapping.hibernate_one_to_one_unidirectional.dto.Laptop;

public class EmployeeLaptopService {

	EmployeeLaptopDao laptopDao = new EmployeeLaptopDao();

	public Employee saveEmployeeLaptopService(Employee e, Laptop l) {
		return laptopDao.saveEmployeeLaptopDao(e, l);
	}
	public Employee getLaptopByEmployeeIdService(int employeeId) {
		return laptopDao.getLaptopByEmployeeIdDao(employeeId);
		}
}
