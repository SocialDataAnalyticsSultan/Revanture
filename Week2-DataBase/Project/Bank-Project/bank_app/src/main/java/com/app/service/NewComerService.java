package com.app.service;

import com.app.exception.BankException;

@FunctionalInterface
public interface NewComerService {
	
	public boolean NewComerApplication() throws BankException;

}
