package com.app.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerTransaction;

public interface CustomerDAO {
	
	public int customerLogIn(String userName, String password) throws ClassNotFoundException, SQLException, BankException;
	public Customer getCustomerInformation (int customerId) throws ClassNotFoundException, SQLException;
	public CustomerAccount getCustomerAccount(int customerId) throws ClassNotFoundException, SQLException;
	public List<CustomerTransaction> getCustomerTransaction(int customerId) throws ClassNotFoundException, SQLException;
	public boolean updateCustomerAddress(int customerId, Address address) throws ClassNotFoundException, SQLException;
	public boolean updateCustomerPhoneNumber(int customerId, String phoneNumber) throws ClassNotFoundException, SQLException;
	public boolean updateCustomerEmail(int customerId, String email) throws ClassNotFoundException, SQLException;
	public boolean updateCustomerPassword(int customerId, String password) throws ClassNotFoundException, SQLException;
	public boolean makeCustomerDeposit(int customerId, BigDecimal deposit) throws ClassNotFoundException, SQLException, BankException;
	public boolean makeCustomerWithDraw(int customerId, BigDecimal withDraw) throws ClassNotFoundException, SQLException, BankException;
	public boolean makeCustomerTransfer(int customerId, BigDecimal transfer, String transferAccountNumber) throws ClassNotFoundException, SQLException, BankException;
	public boolean makeLoanApplication(int customerId, int loanTypeId, BigDecimal loanAmount, int loanDurationYear) throws ClassNotFoundException, SQLException;
	public boolean makeCustomerLoanPayment(int customerId, BigDecimal loanPayment) throws ClassNotFoundException, SQLException, BankException;
}
