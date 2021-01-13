package com.app.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerLoan;
import com.app.model.customer.CustomerTransaction;

public interface EmployeeService {
	
	public int employeeLogIn() throws BankException, ClassNotFoundException, SQLException;
	public Customer getCustomerInformationById(int customerId) throws BankException, ClassNotFoundException, SQLException;
	public Customer getCustomerInformationByAccountNumber(String accountNumber) throws BankException, ClassNotFoundException, SQLException;
	public List<Customer> getCustomerInformationByFirstName(String customerFirstName) throws BankException, ClassNotFoundException, SQLException;
	public List<Customer> getCustomerInformationByLastName(String customerLastName) throws BankException, ClassNotFoundException, SQLException;
	public List<Customer> getCustomerInformationByBankBranchId(int bankBranchId) throws BankException, ClassNotFoundException, SQLException;
	public List<Customer> getCustomerByDateOfBirthRange(Date dateStart, Date dateEnd) throws BankException, ClassNotFoundException, SQLException;
	public CustomerAccount getCustomerAccountById(int customerId) throws ClassNotFoundException, SQLException, BankException;
	public CustomerAccount getCustomerAccountByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException, BankException;
	public List<CustomerAccount> getCustomerAccountByBankBranchId(int bankBranchId) throws ClassNotFoundException, SQLException, BankException;
	public List<CustomerTransaction> getCustomerTransactionByCustomerId(int customerId) throws ClassNotFoundException, SQLException, BankException;
	public List<CustomerTransaction> getCustomerTransactionByAccountNumber(String accountNumber) throws BankException, ClassNotFoundException, SQLException;
	public List<CustomerTransaction> getAllCustomerTransactionByDate(Date date) throws ClassNotFoundException, SQLException, ParseException, BankException;
	public List<CustomerLoan> getAllCustomerLoanApplication() throws ClassNotFoundException, SQLException;
		
}
