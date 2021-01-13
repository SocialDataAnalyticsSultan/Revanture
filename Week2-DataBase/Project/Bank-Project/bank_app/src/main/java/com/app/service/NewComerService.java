package com.app.service;

import java.sql.SQLException;

import com.app.exception.BankException;

@FunctionalInterface
public interface NewComerService {
	public boolean NewComerApplication() throws BankException, ClassNotFoundException, SQLException;

}
