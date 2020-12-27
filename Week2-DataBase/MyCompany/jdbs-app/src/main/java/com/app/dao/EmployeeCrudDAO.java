package com.app.dao;

import java.util.List;

import com.app.exception.CompanyException;
import com.app.model.Employee;

public interface EmployeeCrudDAO {
	
	public int createEmployee (Employee employee) throws CompanyException;
	public void deleteEmployee(int id) throws CompanyException;
	
	public int updateEmployeePhoneNumber(int id, String newPhoneNumber) throws CompanyException;
	public int updateEmployeeEmail(int id, String newEmail) throws CompanyException;
	public int updateEmployeeStreet(int id, String newStreet) throws CompanyException;
	public int updateEmployeeCity(int id, String newCity) throws CompanyException;
	public int updateEmployeeState(int id, String newState) throws CompanyException;
	public int updateEmployeeCountry(int id, String newCountry) throws CompanyException;
	
	public Employee getEmployeeById (int id) throws CompanyException;
	public List<Employee> getAllEmployee() throws CompanyException;
	
}
