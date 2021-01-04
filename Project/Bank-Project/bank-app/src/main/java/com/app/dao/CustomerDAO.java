package com.app.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.model.customer.account.Account;
import com.app.model.customer.account.AccountHistory;
import com.app.model.customer.loan.LoanApplication;
import com.app.model.customer.loan.LoanPayment;
import com.app.model.customer.transaction.Transaction;

public interface CustomerDAO {
	
	public abstract boolean validateLogInInformation(String username, String password) throws BankException;
	public abstract Customer makeRegistration (String firstName, String lastName, Date dateOfBirth, String gender, String maritalStatus,
			String socialSecurityNumber, Address address, String email, String mobilePhone, String nationality,
			String occupation, int creaditScore, BigDecimal yearlyIncome, String userName, String password) throws ClassNotFoundException, SQLException, BankException;
	public abstract Account getAccountInformation(int customerId) throws ClassNotFoundException, SQLException, BankException;
	
	public abstract void makeDeposit(BigDecimal amount, int customerId) throws BankException, SQLException, ClassNotFoundException;
	public abstract void makeWithDraw(BigDecimal amount, int customerId) throws BankException, SQLException, ClassNotFoundException;
	public abstract List<AccountHistory> getAccountHistory(int customerId) throws ClassNotFoundException, SQLException, BankException;
	
	
	public abstract void makeTransansaction(int customerId, String transferAccount, BigDecimal transferAmonth) throws ClassNotFoundException, SQLException, BankException, ParseException;
	public abstract List<Transaction> getTransactionHistory();
	
	public abstract LoanApplication applyForLoan(String loanType, BigDecimal loanAmount);
	public abstract void payForLoan(BigDecimal amount);
	public abstract List<LoanPayment> getLoanPaymentInformation();
	
}
