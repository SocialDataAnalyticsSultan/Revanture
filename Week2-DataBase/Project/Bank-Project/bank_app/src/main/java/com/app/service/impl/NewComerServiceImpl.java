package com.app.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.NewComerDAO;
import com.app.dao.impl.NewComerDAOImpl;
import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.service.NewComerService;
import com.app.model.Address;

public class NewComerServiceImpl implements NewComerService {

	private static Logger log=Logger.getLogger(NewComerServiceImpl.class);
	
	@Override
	public boolean NewComerApplication() throws BankException, ClassNotFoundException, SQLException {
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
		String sDate = sc.nextLine();
		if(!sDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
			throw new BankException("Invalid Date of Birth");
		}
		
		LocalDate now=LocalDate.now();
		LocalDate dob=LocalDate.parse(sDate, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
		Period pAge = Period.between(dob, now);
		int age = pAge.getYears();
		if(age<16) {
			throw new BankException("You are too young to open an account.");	
		}else if(age>120) {
			throw new BankException("Wrong date.");
		}
		
		Date dateOfBirth = null;
		try {
			dateOfBirth= new SimpleDateFormat("MM-dd-yyyy").parse(sDate);
		} catch (ParseException e) {
			e.getMessage();
		}
		
		System.out.print("Gender (Female/Male): ");
		String gender = sc.nextLine();
		if( (gender.toUpperCase().compareTo("FEMALE") !=0) && (gender.toUpperCase().compareTo("MALE")!=0)) {
			throw new BankException("Invalid Gender.");
		}
		
		System.out.print("Marital Status (Single/Married) (Optional): ");
		String maritalStatus = sc.nextLine();
		if (maritalStatus.isBlank()) {
			maritalStatus = null;
		}
		
		System.out.print("Nationality (Optional): ");
		String nationality = sc.nextLine();
		if(nationality.isBlank()) {
			nationality = null;
		}
		
		System.out.print("Social Security Number (000-00-0000): ");
		String socialSecurityNumber = sc.nextLine();
		if(!socialSecurityNumber.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}")){
			throw new BankException("Invalid Social Security Number.");
		}
		
		System.out.println("Adress Information ");
		System.out.print("Street: ");
		String street = sc.nextLine();
		System.out.print("City: ");
		String city = sc.nextLine();
		System.out.print("State: ");
		String state = sc.nextLine();
		System.out.print("Country: ");
		String country = sc.nextLine();
		System.out.print("Zipcode (0000): ");
		String zipcode = sc.nextLine();
		if(!zipcode.matches("[0-9]{4}")) {
			throw new BankException("Invalid Zipcode.");
		}
		Address address = new Address(street, city, state, country, zipcode);
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		if(!email.matches("[^\s]{1,}@[^\s]{1,}")) {
			throw new BankException("Invalid Email.");
		}
		
		System.out.print("Phone Number (000-000-0000): ");
		String phoneNumber = sc.nextLine();
		if(!phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
			throw new BankException("Invalid Phone Number.");
		}
		
		System.out.print("Occupation: ");
		String occupation = sc.nextLine();
		if(occupation.isBlank()) {
			throw new BankException("Invalid Occupation.");
		}
		
		System.out.print("Yearly Income: ");
		String sYearlyIncome = sc.nextLine();
		if(!sYearlyIncome.matches("[1-9]{1}[0-9]{1,}")) {
			throw new BankException("Invalid Yearly Income.");
		}
		BigDecimal yearlyIncome = new BigDecimal(sYearlyIncome);
		
		System.out.print("Credit Score: ");
		int creditScore = Integer.parseInt(sc.nextLine());
		if(creditScore<0 || creditScore>1000) {
			throw new BankException("Invalid Credit Score.");
		}
		
		System.out.println("\n\nThank you providing necessary information");
		System.out.println("You need to choice username and password to access your accunt");
		System.out.println("You can use any letter, digit or special character.");
		System.out.println("Both should be at least 4 character.");
		System.out.println("Please do not share this information with anyone.");
		
		System.out.print("Username: ");
		String userName = sc.nextLine();
		if(userName.isBlank() || userName.length()<4) {
			throw new BankException("Invalid Username.");
		}
		
		System.out.print("Password: ");
		String password = sc.nextLine();
		if(password.isBlank() || password.length()<4) {
			throw new BankException("Invalid Password.");
		}
		
		NewComerDAO newComer = new NewComerDAOImpl();
		int customerId = newComer.NewComerApplication();
		System.out.println("Your customer identification number is " + customerId);
		System.out.println("\n\n");
		
		newCustomer = new Customer(firstName, lastName, dateOfBirth, gender, maritalStatus,
				nationality, socialSecurityNumber, address, email, phoneNumber,
				customerId, occupation, yearlyIncome, creditScore, userName, password);
		
		//System.out.println(newCustomer);
		System.out.println("Please provide the following information to open an account");
		System.out.print("Account type (Saving/Checking): ");
		String accountType = sc.nextLine();
		if( (accountType.toUpperCase().compareTo("SAVING") !=0) && (accountType.toUpperCase().compareTo("CHECKING")!=0)) {
			throw new BankException("Invalid Account Type.");
		}
		
		int bankBranchId = 0;
		int approvingEmployeeId = 0;
		System.out.println("Choose your bank branch");
		System.out.println("(100) Boston ");
		System.out.println("(101) Brockton ");
		System.out.println("(102) Cambridge ");
		System.out.println("(103) Lynn ");
		System.out.println("(104) New Bedford ");
		System.out.println("(105) Newton ");
		System.out.println("(106) Springfield ");
		System.out.println("(107) Waltham ");
		System.out.println("(108) Watertown ");
		System.out.println("(109) Woburn ");
		System.out.println("(110) Worcester ");
		System.out.println("Your branch choice code: ");
		
		Map<Integer, String> bank = new HashMap<>();
		bank.put(100, "Boston");
		bank.put(101, "Brockton");
		bank.put(102, "Cambridge");
		bank.put(103, "Lynn");
		bank.put(104, "New Bedford");
		bank.put(105, "Newton");
		bank.put(106, "Springfield");
		bank.put(107, "Waltham");
		bank.put(108, "Watertown");
		bank.put(109, "Woburn");
		bank.put(110, "Worcester");
		
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		map.put("Boston", Arrays.asList(1045, 1047, 1048, 1049, 1050));
		map.put("Brockton", Arrays.asList(1018, 1019, 1027, 1028, 1040));
		map.put("Cambridge", Arrays.asList(1010, 1013, 1022, 1041, 1051));
		map.put("Lynn", Arrays.asList(1026, 1031, 1033, 1035, 1037));
		map.put("New Bedford", Arrays.asList(1015, 1020, 1025, 1030, 1053));
		map.put("Newton", Arrays.asList(1016, 1017, 1021, 1024, 1043));
		map.put("Springfield", Arrays.asList(1038, 1042, 1044, 1052, 1054));
		map.put("Waltham", Arrays.asList(1000, 1001, 1002, 1003, 1009));
		map.put("Watertown", Arrays.asList(1007, 1008, 1012, 1014, 1029));
		map.put("Woburn", Arrays.asList(1004, 1005, 1006, 1011, 1023));
		map.put("Worcester", Arrays.asList(1032, 1034, 1036, 1039, 1046));
		
		try {
			bankBranchId = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
		}
		
		String bankBranchName = null;
		if(bankBranchId >= 100 && bankBranchId <= 110) {
			bankBranchName = bank.get(bankBranchId);
			List<Integer> allApprovingEmployeeId = map.get(bankBranchName);
			Random rand = new Random();
			approvingEmployeeId = allApprovingEmployeeId.get(rand.nextInt(allApprovingEmployeeId.size()));
			
		}else {
			throw new BankException("Invalid Bank Branch Code.");
		}
		
		int minNumber = 1000;
		int maxNumber = 9999;
		String random1 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
		String random2 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
		String random3 = String.valueOf((int)(Math.random()*(maxNumber-minNumber+1)+minNumber));
		
		String accountNumber = random1 + "-" + random2 + "-" + random3;
		
		BigDecimal deposit = new BigDecimal(0);
		System.out.print("Enter the amount you would like to deposit: ");
		
		try {
			deposit = new BigDecimal(sc.nextLine());
			if(deposit.doubleValue()<0) {
				System.out.println("You cannot withdraw without openning an accout. ");
				deposit = new BigDecimal(0);
			}
		} catch (NumberFormatException e) {
			log.error(e.getMessage());
		}
		
		CustomerAccount newCustomerAccount = new CustomerAccount(customerId, accountType, 
				accountNumber, new Date(), deposit, bankBranchId, approvingEmployeeId);
		
		newComer.NewComerAccountAndRegistration(newCustomer, newCustomerAccount);
		
		System.out.println("\n\n\nCONGRATULATIONS!!!!");
		System.out.println("Your Account Number is " +  accountNumber);
		
		log.info(newCustomer);
		log.info(accountNumber);
		
		return true;
	}

}
