package com.app.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;

import com.app.exception.BankException;
import com.app.model.customer.Customer;

public interface CustomerService {
	
	public abstract boolean customerLogIn() throws BankException;
	public abstract Customer customerRegistration() throws ParseException, ClassNotFoundException, SQLException; 
	public abstract void customerAccountInformation() throws BankException, ClassNotFoundException, SQLException;
	public abstract void customerMakeDeposit() throws BankException, ClassNotFoundException, SQLException;
	public abstract void customerMakeWithDraw() throws BankException, ClassNotFoundException, SQLException;
	public abstract void customerAccountHistory() throws BankException, ClassNotFoundException, SQLException;
	public abstract void customerMakeTransaction() throws BankException, ClassNotFoundException, SQLException, ParseException;
}
