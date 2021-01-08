package com.app.service.impl;

import java.util.Scanner;

import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.service.NewComerService;

public class NewComerServiceImpl implements NewComerService {

	@Override
	public boolean NewComerApplication() throws BankException {
		Scanner sc = new Scanner(System.in);
		Customer newCustomer = null;
		System.out.println("Please provide the following information");
		
		System.out.print("First Name: ");
		String firstName = sc.nextLine();
		if(firstName.matches("[0-9]{1,}") || firstName.matches("[^a-zA-Z]")) {
			throw new BankException("Invalid First Name");
		}
		
		System.out.print("Last Name: ");
		String lastName = sc.nextLine();
		if(lastName.matches("[0-9]{1,}") || lastName.matches("[^a-zA-Z]")) {
			throw new BankException("Invalid Last Name");
		}
		
		System.out.print("Date of Birth (mm-dd-yyyy): ");
		String sdate = sc.nextLine();
		if(!sdate.matches("[0-9]{2}-[0-9]{2}-[0-9]{2}")) {
			throw new BankException("Invalid Date of Birth");
		}else{
			
		}
		
		return false;
	}

}
