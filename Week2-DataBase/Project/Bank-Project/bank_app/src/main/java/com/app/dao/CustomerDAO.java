package com.app.dao;

import java.util.List;

import com.app.model.customer.CustomerTransaction;

public interface CustomerDAO {
	
	public boolean CustomerLogIn();
	public boolean CustomerMakeTransaction();
	public void CustomerApplyLoan();
	public List<CustomerTransaction> CustomerViewTransaction();

}
