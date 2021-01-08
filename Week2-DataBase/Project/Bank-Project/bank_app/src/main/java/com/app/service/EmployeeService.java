package com.app.service;

import java.util.Date;
import java.util.List;

import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerTransaction;

public interface EmployeeService {
	
	public boolean EmployeeLogIn();
	public List<Customer> getCustomerByDobRange(Date date1, Date date2);
	public List<CustomerAccount> getCustomerAccountByBankBranch(int branchId);
	public CustomerAccount getCustomerById(int customerId);
	public CustomerAccount getCustomerByAccount(String customerAccount);
	public List<CustomerTransaction> getCustomerTransactionById();
	public List<CustomerTransaction> getCustomerTransactionByStartDate(Date date);
	
}
