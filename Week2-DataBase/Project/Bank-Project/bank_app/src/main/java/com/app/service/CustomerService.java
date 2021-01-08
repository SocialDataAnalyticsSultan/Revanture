package com.app.service;

import java.util.List;
import com.app.model.customer.CustomerTransaction;

public interface CustomerService {
	
	public boolean CustomerLogIn();
	public boolean CustomerMakeTransaction();
	public void CustomerApplyLoan();
	public List<CustomerTransaction> CustomerViewTransaction();

}
