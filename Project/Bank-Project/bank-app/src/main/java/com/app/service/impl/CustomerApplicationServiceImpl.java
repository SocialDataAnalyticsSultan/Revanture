package com.app.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.app.dao.CustomerDAO;
import com.app.dao.impl.CustomerDAOImpl;
import com.app.exception.BankException;
import com.app.model.Address;
import com.app.model.customer.Customer;
import com.app.service.CustomerApplicationService;

public class CustomerApplicationServiceImpl implements CustomerApplicationService{

	@Override
	public Customer customerApplication() throws BankException, ParseException, ClassNotFoundException, SQLException {
		
		Customer newCustomer = null;
		String firstName = null;
		String lastName = null;
		Date dateOfBirth = null;
		String gender = null;
		String maritalStatus = null;
		String socialSecurityNumber = null;
		String street = null;
		String city = null;
		String state = null;
		String country = null;
		String zipcode = null;
		Address customerAddress = null;
		String email = null;
		String mobilePhone = null;
		String nationality = null;
		String occupation = null;
		int creaditScore = 0;
		BigDecimal yearlyIncome = new BigDecimal(0);
		String userName = null;
		String password = null;
				
		Scanner sc = new Scanner(System.in);
		System.out.println("Wellcome to Application Service.");
		System.out.println("Please provide following information.");
		System.out.println("=======================================");

		
		
		try {
			System.out.print("First Name: ");
			firstName = sc.nextLine();
			if(!firstName.matches("[a-zA-Z]{2,}")) {
				throw new BankException("Invalid Name");
			}
			
			System.out.print("Last Name: ");
			lastName = sc.nextLine();
			if (lastName.matches("[a-zA-Z]{2,}")){
				throw new BankException("Invalid Last Name");
			}
			
			System.out.print("Date of Birth (mm/dd/yyyy): ");
			String date = sc.nextLine();
			
			if(date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
				SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
				sdf.setLenient(false);
				dateOfBirth = sdf.parse(date);
				
			}else {
				throw new BankException("Invalid Date");
			}
			
			System.out.print("Gender: (Female/Male) ");
			gender = sc.nextLine();
			if (!gender.matches("F|M")) {
				throw new BankException("Invalid Gender");
			}
			
			System.out.print("Marital Status: ");
			maritalStatus = sc.nextLine();
			
			System.out.print("Social Security Number 000-00-0000: ");
			socialSecurityNumber = sc.nextLine();
			if(!socialSecurityNumber.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}")) {
				throw new BankException("Invalid Social Security Number");
			}
			
			System.out.println("Address ");
			System.out.print("Street: ");
			street = sc.nextLine();
			if(street == null) {
				throw new BankException("Invalid Street");
			}
			
			System.out.print("City: ");
			city = sc.nextLine();
			if(city == null) {
				throw new BankException("Invalid City");
			}
			
			System.out.print("State: ");
			state = sc.nextLine();
			if(state == null) {
				throw new BankException("Invalid State");
			}
			
			System.out.print("Country: ");
			country = sc.nextLine();
			if(country == null) {
				throw new BankException("Invalid Country");
			}
			
			System.out.print("Zipcode: ");
			zipcode = sc.nextLine();
			if(!zipcode.matches("[0-9]{5}")) {
				throw new BankException("Invalid Zipcode");
			}
			
			customerAddress = new Address(street, city, state, zipcode, country);
			
			System.out.print("Email: ");
			email = sc.nextLine();
			if(!email.matches("[a-zA-Z0-9]{2,}@[a-zA-Z0-9]{2,}")) {
				throw new BankException("Invalid Email");
			}
			
			System.out.print("Phone Number (+1-000-000-0000): ");
			mobilePhone = sc.nextLine();
			if(!mobilePhone.matches("\\+1-[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
				throw new BankException("Invalid Phone Number");
			}
			
			System.out.print("Nationality: ");
			nationality = sc.nextLine();
			
			System.out.print("Occupation: ");
			occupation = sc.nextLine();
			if(!occupation.matches("[a-zA-Z]{3,}")) {
				throw new BankException("Invalid Occupation");
			}
			
			System.out.print("Credit Score: ");
			try {
				creaditScore = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				throw e;
			}
			
			if(creaditScore<0) {
				throw new BankException("Invalid Credit Score");
			}
			
			System.out.print("Yearly Income: ");
			Double dyearlyIncome = 0.0;
			
			try {
				dyearlyIncome = Double.parseDouble(sc.nextLine());
			}catch (NumberFormatException e) {
				throw e;
			} 
			
			if(dyearlyIncome<0) {
				throw new BankException("Invalid Yearly Income");
			}else {
				yearlyIncome = BigDecimal.valueOf(dyearlyIncome);
			}
			
			System.out.println();
			System.out.println("Thank you providing information");
			System.out.println("Your application has been recived. "
					+ "\nYou can set username and password as soon as your application has been approved.");
			
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		catch(BankException e) {
			System.out.println(e.getMessage());
		}
		
		boolean employeeApproval = true;
		CustomerDAO newCustomerDAO = new CustomerDAOImpl();
		
		if(employeeApproval) {
			
			System.out.println("Your Application has been approved.");
			int attempt = 0;
			boolean validUserName = false;
			boolean validPassword = false;
			do {
				attempt++;
				try {
					System.out.println("Please chose username and password for online bank application.");
					System.out.println("Username and password can contain uppercase or lowercase letter, numbers or special characters.");
					System.out.println("Username and password should be at least 5 characters.");
					System.out.print("Username: ");
					
					userName = sc.nextLine();
					if(!userName.matches("[a-zA-Z0-9_*$%@-!~.,:]{5,}")) {
						throw new BankException("Invalid Username");
					}else {
						validUserName = true;
					}
					
					System.out.print("Password: ");
					password = sc.nextLine();
					if(!password.matches("[a-zA-Z0-9_*$%@-!~.,:]{5,}")) {
						throw new BankException("Invalid Password");
					}else {
						validPassword = true;
					}
					
				}catch(BankException e) {
					System.out.println(e.getMessage());
				}
				
			}while(attempt<3 && !validUserName && !validPassword);
			
			if(!validUserName || !validPassword) {
				System.out.println("Please Contact to Customer Representative");
			}else {
				newCustomer = newCustomerDAO.makeRegistration(firstName, lastName, dateOfBirth, gender, maritalStatus,
						socialSecurityNumber, customerAddress, email, mobilePhone, nationality,
						occupation, creaditScore, yearlyIncome, userName, password);	
				System.out.println("Your customer identification number is " + newCustomer.getCustomerId());
			}
				
			
		}
		return newCustomer;
	}

}
