package com.app.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerLoan;
import com.app.model.customer.CustomerTransaction;

public interface EmployeeDAO {
	
	public int employeeLogIn(String userName, String password) throws ClassNotFoundException, SQLException, BankException;
	public Customer getCustomerInformationById(int customerId) throws ClassNotFoundException, SQLException;
	public Customer getCustomerInformationByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException;
	public List<Customer> getCustomerInformationByFirstName(String customerFirstName) throws ClassNotFoundException, SQLException, BankException;
	public List<Customer> getCustomerInformationByLastName(String customerLastName) throws ClassNotFoundException, SQLException, BankException;
	public List<Customer> getCustomerInformationByBankBranchId(int bankBranchId) throws ClassNotFoundException, SQLException, BankException;
	public List<Customer> getAllCustomerByDateOfBirthRange(Date dateStart, Date dateEnd) throws ClassNotFoundException, SQLException;
	public CustomerAccount getCustomerAccountById(int customerId) throws ClassNotFoundException, SQLException, BankException;
	public CustomerAccount getCustomerAccountByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException, BankException;
	public List<CustomerAccount> getCustomerAccountByBankBranchId(int bankBranchId) throws ClassNotFoundException, SQLException;
	public List<CustomerTransaction> getCustomerTransactionByCustomerId(int customerId) throws ClassNotFoundException, SQLException;
	public List<CustomerTransaction> getCustomerTransactionByAccountNumber(String accountNumber) throws ClassNotFoundException, SQLException;
	public List<CustomerTransaction> getAllCustomerTransactionByStartDate(Date date) throws ClassNotFoundException, SQLException;
	public List<CustomerLoan> getAllCustomerLoanApplication() throws ClassNotFoundException, SQLException;
	
}
