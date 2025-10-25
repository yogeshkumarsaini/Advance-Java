package com.mapping.hibernate_one_to_one_unidirectional.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mapping.hibernate_one_to_one_unidirectional.dto.Employee;
import com.mapping.hibernate_one_to_one_unidirectional.dto.Laptop;

public class EmployeeLaptopDao {

	EntityManagerFactory eMF = Persistence.createEntityManagerFactory("jpa");
	EntityManager em = eMF.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Employee saveEmployeeLaptopDao(Employee e, Laptop l) {
		et.begin();
		/*
		 * this is setter method
		 */
		e.setLaptop(l);

		em.persist(e);
		em.persist(l);
		et.commit();
		return e;

	}

	public Employee getLaptopByEmployeeIdDao(int employeeId) {
		return em.find(Employee.class, employeeId);
	}

	public Employee deleteLaptopAndEmployeeByEmployeeIdDao(int employeeId) {
		Employee employee = getLaptopByEmployeeIdDao(employeeId);
		if (employee != null) {
			et.begin();
			em.remove(employee);
			et.commit();
			return employee;
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param e
	 * @param laptopId
	 * @return
	 */
	public Employee saveEmployeeLaptopDao(Employee e, int laptopId) {
		Laptop l=em.find(Laptop.class, laptopId);
		
		getLaptopByEmployeeIdDao(e.getId());
		
		if(l!=null) {
			e.setLaptop(l);
		}
		et.begin();
		/*
		 * this is setter method
		 */
		

		em.persist(e);
		//em.persist(l);
		et.commit();
		return e;

	}
	/*
	 * Display all
	 */

	public List<Employee> getAllEmployeeAndLaptopDetails(){
		Query query=em.createQuery("from Employee");
		return query.getResultList();
	}
}
