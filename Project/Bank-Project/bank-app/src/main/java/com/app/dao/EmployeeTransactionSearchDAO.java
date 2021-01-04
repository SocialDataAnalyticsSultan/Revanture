package com.app.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.app.model.customer.transaction.Transaction;

public interface EmployeeTransactionSearchDAO {
	
	public abstract List<Transaction> getCustomerAllTransaction(String customerId);
	public abstract List<Transaction> getCustomerHighTransaction(BigDecimal minTransferAmount);
	public abstract List<Transaction> getCustomerTransactionBetweenDates(Date start, Date end);

}