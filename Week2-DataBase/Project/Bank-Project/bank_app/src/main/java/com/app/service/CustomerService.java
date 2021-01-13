package com.app.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerTransaction;

public interface CustomerService {
	
	public int customerLogIn() throws NumberFormatException, BankException, ClassNotFoundException, SQLException;
	public Customer getCustomerInformation(int customerId) throws ClassNotFoundException, SQLException, BankException;
	public CustomerAccount getCustomerAccount(int customerId) throws ClassNotFoundException, SQLException;
	public List<CustomerTransaction> getCustomerTransaction(int customerId) throws ClassNotFoundException, SQLException;
	public boolean updateCustomerAddress(int customerId, String street, String city,String  state,String country,String zipcode) throws BankException, ClassNotFoundException, SQLException;
	public boolean updateCustomerPhoneNumber(int customerId, String phoneNumber) throws BankException, ClassNotFoundException, SQLException;
	public boolean updateCustomerEmail(int customerId, String email) throws BankException, ClassNotFoundException, SQLException;
	public boolean updateCustomerPassword(int customerId, String password) throws BankException, ClassNotFoundException, SQLException;
	public boolean makeCustomerDeposit(int customerId, BigDecimal deposit) throws BankException, ClassNotFoundException, SQLException;
	public boolean makeCustomerWithDraw(int customerId, BigDecimal withDraw) throws BankException, ClassNotFoundException, SQLException;
	public boolean makeCustomerTransfer(int customerId, BigDecimal transfer, String transferAccountNumber) throws BankException, ClassNotFoundException, SQLException;
	public boolean makeLoanApplication(int customerId, int loanTypeId, BigDecimal loanAmount, int loanDurationYear) throws BankException, ClassNotFoundException, SQLException;
	public boolean makeCustomerLoanPayment(int customerId, BigDecimal loanPayment) throws BankException, ClassNotFoundException, SQLException;

}
