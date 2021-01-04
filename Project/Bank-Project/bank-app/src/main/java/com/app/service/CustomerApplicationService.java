package com.app.service;

import java.sql.SQLException;
import java.text.ParseException;

import com.app.exception.BankException;
import com.app.model.customer.Customer;

public interface CustomerApplicationService {
	
	public Customer customerApplication() throws BankException, ParseException, ClassNotFoundException, SQLException;

}
