package com.app.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.app.dao.EmployeeAccountSearchDAO;
import com.app.model.customer.account.Account;

public class EmployeeAccountSearchDAOImpl implements EmployeeAccountSearchDAO{

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByCustomerId(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountByBranchId(String branchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountByApprovingEmployee(String branchId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountByBalanceRange(BigDecimal balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountByDateOfOpenRange(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAccountHistoryByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		
	}

}
