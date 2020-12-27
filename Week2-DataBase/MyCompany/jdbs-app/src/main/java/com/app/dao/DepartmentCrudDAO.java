package com.app.dao;

import java.util.List;

import com.app.exception.CompanyException;
import com.app.model.Department;

public interface DepartmentCrudDAO {
	
	public int createDepartment (Department department) throws CompanyException;
	public void deleteDepartment(int id) throws CompanyException;
	
	public int updateDepartmentName(int id, String newDepartmentName) throws CompanyException;
	public int updateDepartmentCity(int id, String newCity) throws CompanyException;
	public int updateDepartmentState(int id, String newState) throws CompanyException;
	public int updateDepartmentCountry(int id, String newCountry) throws CompanyException;
	public int updateManagerId (int id, int newManagerId) throws CompanyException;
	
	public Department getDepartmentById (int id) throws CompanyException;
	public List<Department> getAllDepartment() throws CompanyException;
	

}
