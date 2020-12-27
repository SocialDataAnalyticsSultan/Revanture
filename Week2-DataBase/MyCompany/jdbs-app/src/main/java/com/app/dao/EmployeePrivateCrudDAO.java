package com.app.dao;

import java.util.List;

import com.app.exception.CompanyException;
import com.app.model.EmployeePrivate;

public interface EmployeePrivateCrudDAO {
	
	public int createEmployeePrivate(EmployeePrivate employeePrivate) throws CompanyException;
	public void deleteEmployeePrivate(int id) throws CompanyException;
	
	public int updateSocialSecurityNumber(int id, String newSocialSecurityNumber) throws CompanyException;
	public int updateAccountNumber(int id, String newAccountNumber) throws CompanyException;
	public int updateUserName(int id, String newUserName) throws CompanyException;
	public int updatePassword(int id, String newPassword) throws CompanyException;
	
	public EmployeePrivate getEmployeePrivateById(int id) throws CompanyException;
	public List<EmployeePrivate> getAllEmployeePrivate() throws CompanyException;

}
