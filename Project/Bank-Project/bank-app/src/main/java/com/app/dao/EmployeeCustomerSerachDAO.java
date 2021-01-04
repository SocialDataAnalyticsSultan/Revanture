package com.app.dao;

import java.util.List;

import com.app.model.customer.Customer;

public interface EmployeeCustomerSerachDAO {
	
	public abstract Customer getCustomerByCustomerId(String customerId); 
	public abstract List<Customer> getCustomerByLastName(String lastName);
	public abstract List<Customer> getCustomerByFullName(String firstName, String lastName);
	public abstract Customer getCustomerBySocialSecurityNumber(String socialSecurityNumber);
	public abstract Customer getCustomerByEmail(String email);
	public abstract Customer getCustomerByMobilePhone(String mobilePhone);
	
	public abstract List<Customer> getCustomerWithHighCreditScore(int minCreditScore);
	public abstract List<Customer> getCustomerBetweenAge(int minAge, int maxAge);
	public abstract List<Customer> getAllCustomer();	
	
}
