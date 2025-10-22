package com.wipro.hibernate_jpa_crud_operation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

import com.wipro.hibernate_jpa_crud_operation.dto.Company;

/**
 * 
 * @author yogesh
 *
 */
public class CompanyDao {

	/**
	 * this line is used to read the connection from persistance.xml file where jpa
	 * is persistanceUnit name..
	 */

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager entityManager = emf.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Company saveCompanyDao(Company company) {
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
		return company;
	}

	/**
	 * Select * from company where id = ?;
	 * 
	 * @param id
	 * @return
	 */
	public Company getCompanyByIdDao(int id) {
		return entityManager.find(Company.class, id);
	}

	public boolean deleteCompanyByIdDao(int id) {
		Company company = getCompanyByIdDao(id);
		if (company != null) {
			entityTransaction.begin();
			entityManager.remove(company);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Company updateCompanyByIdDao(int id, String name) {
		Company company = getCompanyByIdDao(id);
		if (company != null) {
			company.setName(name);
			entityTransaction.begin();
			entityManager.merge(company);
			entityTransaction.commit();
			return company;
		} else {
			return null;
		}
	}

	public List<Company> getAllCompanyDetailsDao() {

		String selectQuery = "SELECT c FROM Company c";
		Query query = entityManager.createQuery(selectQuery);
		return query.getResultList();

	}

}
