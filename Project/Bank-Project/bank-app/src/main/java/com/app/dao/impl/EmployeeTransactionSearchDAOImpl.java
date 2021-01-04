package com.app.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.app.dao.EmployeeTransactionSearchDAO;
import com.app.model.customer.transaction.Transaction;

public class EmployeeTransactionSearchDAOImpl implements EmployeeTransactionSearchDAO{

	@Override
	public List<Transaction> getCustomerAllTransaction(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getCustomerHighTransaction(BigDecimal minTransferAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getCustomerTransactionBetweenDates(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
