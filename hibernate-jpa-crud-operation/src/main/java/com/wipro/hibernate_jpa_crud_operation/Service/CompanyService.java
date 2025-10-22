package com.wipro.hibernate_jpa_crud_operation.Service;

import java.util.List;

import com.wipro.hibernate_jpa_crud_operation.dao.CompanyDao;
import com.wipro.hibernate_jpa_crud_operation.dto.Company;

public class CompanyService {

	CompanyDao companyDao = new CompanyDao();

	public Company saveCompanyService(Company company) {
		return companyDao.saveCompanyDao(company);
	}

	public Company getCompanyByIdService(int id) {
		return companyDao.getCompanyByIdDao(id);
	}

	public boolean deleteCompanyByIdService(int id) {
		return companyDao.deleteCompanyByIdDao(id);
	}

	public Company updateCompanyByIdService(int id, String name) {
		return companyDao.updateCompanyByIdDao(id, name);
	}

	public List<Company> getAllCompanyDetailsService() {
		return companyDao.getAllCompanyDetailsDao();
	}
}
