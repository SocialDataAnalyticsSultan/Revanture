package com.app.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.app.model.customer.account.Account;

public interface EmployeeAccountSearchDAO {
	
	abstract public Account getAccountByAccountNumber(String accountNumber);
	abstract public Account getAccountByCustomerId(String accountNumber);
	
	abstract public List<Account> getAccountByBranchId(String branchId);
	abstract public List<Account> getAccountByApprovingEmployee(String branchId);
	abstract public List<Account> getAccountByBalanceRange(BigDecimal balance);
	abstract public List<Account> getAccountByDateOfOpenRange(Date start, Date end);
	
	abstract public void getAccountHistoryByCustomerId(String customerId);
}
