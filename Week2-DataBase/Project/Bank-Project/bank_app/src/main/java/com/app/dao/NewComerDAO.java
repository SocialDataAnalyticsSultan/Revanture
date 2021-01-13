package com.app.dao;

import java.sql.SQLException;

import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;


public interface NewComerDAO {
	
	public int NewComerApplication() throws ClassNotFoundException, SQLException;
	public void NewComerAccountAndRegistration(Customer newCustomer, CustomerAccount newCustomerAccount) throws ClassNotFoundException, SQLException;

}
