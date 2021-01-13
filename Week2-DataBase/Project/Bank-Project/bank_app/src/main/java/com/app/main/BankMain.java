package com.app.main;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.exception.BankException;
import com.app.model.customer.Customer;
import com.app.model.customer.CustomerAccount;
import com.app.model.customer.CustomerLoan;
import com.app.model.customer.CustomerTransaction;
import com.app.service.CustomerService;
import com.app.service.EmployeeService;
import com.app.service.NewComerService;
import com.app.service.impl.CustomerServiceImpl;
import com.app.service.impl.EmployeeServiceImpl;
import com.app.service.impl.NewComerServiceImpl;

public class BankMain {
	
	private static Logger log=Logger.getLogger(BankMain.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO ASYA BANK");
		System.out.println("====================");
		
		int choice = 0;
		
		int employeeId = 0;
		int employeeChoice = 0;
		int bankBranchId = 0;
		int customerId = 0;
		String accountNumber = null;
		String customerFirstName = null;
		String customerLastName = null;
		String strSDate = null;
		String strEDate = null;
		Date dateStart = null;
		Date dateEnd = null;
		String strDate = null;
		Date date = null;
		String street = null;
		String city = null;
		String state = null;
		String country = null;
		String zipcode = null;
		String phoneNumber = null;
		String email =  null;
		String password = null;
		BigDecimal deposit = new BigDecimal(0);
		BigDecimal withDraw = new BigDecimal(0);
		BigDecimal transfer = new BigDecimal(0);
		String transferAccountNumber = null;
		int loanTypeId = 0;
		BigDecimal loanAmount = new BigDecimal(0);
		int loanDurationYear = 0;
		Customer customer = null;
		CustomerAccount customerAccount = null;
		List <Customer> customerList = new ArrayList<>();
		List <CustomerAccount> customerAccountList = null;
		List<CustomerTransaction> customerTransactionList = new ArrayList<>(); 
		List<CustomerTransaction> allCustomerTransactionList = new ArrayList<>(); 
		List<CustomerLoan> allCustomerLoanList = new ArrayList<>();
		
		do {
			System.out.println("BANK MAIN MENU");
			System.out.println("====================");
			System.out.println("Please enter:");
			System.out.println("(1) If you are customer");
			System.out.println("(2) If you are emplooye");
			System.out.println("(3) If you a newcomer");
			System.out.println("(4)EXIT");
			System.out.println("Please enter appropriate choice between 1-4\n");
			
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				log.error(e.getMessage());
			}
			
			switch (choice) {
			case 1:
				System.out.println("\n\nPlease login.");
				CustomerService customerService = new CustomerServiceImpl();
				int customerChoice = 0;
				try {
					customerId = 0;
					customerId = customerService.customerLogIn();
					if(customerId>0) {
						do {
							System.out.println("\nPLEASE ENTER:");
							System.out.println("(1) If you want to see your personal information. ");
							System.out.println("(2) If you want to see your account information. ");
							System.out.println("(3) If you want to see your transaction history. ");
							System.out.println("(4) If you want to update your address. ");
							System.out.println("(5) If you want to update your phone number. ");
							System.out.println("(6) If you want to update your email. ");
							System.out.println("(7) If you want to update your password. ");
							System.out.println("(8) If you want to deposit money in your account. ");
							System.out.println("(9) If you want to withdraw money from your account. ");
							System.out.println("(10) If you want to transer money to another account. ");
							System.out.println("(11) If you want to apply for a loan. ");
							System.out.println("(12) If you want to pay for a loan. ");
							System.out.println("(13) If you want to exit from your account. \n\n");
							
							customerChoice = Integer.parseInt(sc.nextLine());
							switch(customerChoice) {
							
							case 1:
								customer = null;
								try {
									customer = customerService.getCustomerInformation(customerId);
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
							
							case 2:
								customerAccount = null;
								try {
									customerAccount = customerService.getCustomerAccount(customerId);
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 3:
								customerTransactionList = null;
								try {
									customerTransactionList = customerService.getCustomerTransaction(customerId);
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								
								break;
								
							case 4:
								try {
									System.out.println("Adress Information ");
									System.out.print("Street: ");
									street = sc.nextLine();
									System.out.print("City: ");
									city = sc.nextLine();
									System.out.print("State: ");
									state = sc.nextLine();
									System.out.print("Country: ");
									country = sc.nextLine();
									System.out.print("Zipcode (0000): ");
									zipcode = sc.nextLine();
									
									boolean isAddressChange = false;
									isAddressChange = customerService.updateCustomerAddress(customerId, street, city, state, country, zipcode);
									if(isAddressChange) {
										System.out.println("Address updated successfully...");
									}
									else {
										throw new BankException("There is a problem in address update. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 5:
								System.out.print("Phone Number (000-000-0000): ");
								boolean isPhoneNumberChange = false;
								try {
									phoneNumber = sc.nextLine();
									isPhoneNumberChange = customerService.updateCustomerPhoneNumber(customerId, phoneNumber);
									if(isPhoneNumberChange) {
										System.out.println("Phone Number updated successfully...");
									}
									else {
										throw new BankException("There is a problem in phone number update. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 6:
								System.out.print("Email: ");
								boolean isEmailChange = false;
								try {
									email = sc.nextLine();
									isEmailChange = customerService.updateCustomerEmail(customerId, email);
									if(isEmailChange) {
										System.out.println("Email updated successfully...");
									}
									else {
										throw new BankException("There is a problem in email update. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 7:
								System.out.print("Password: ");
								boolean isPasswordChange = false;
								try {
									password = sc.nextLine();
									isPasswordChange = customerService.updateCustomerPassword(customerId, password);
									if(isPasswordChange) {
										System.out.println("Password updated successfully...");
									}
									else {
										throw new BankException("There is a problem in password update. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 8:
								System.out.print("Enter the amount you would like to deposit: ");
								boolean isDeposit = false;
								try {
									deposit = new BigDecimal(0);
									deposit = new BigDecimal(sc.nextLine());
									isDeposit = customerService.makeCustomerDeposit(customerId, deposit);
									if(isDeposit) {
										System.out.println("Deposit made successfully...");
									}
									else {
										throw new BankException("There is a problem in deposit. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 9:
								System.out.print("Enter the amount you would like to withdraw: ");
								boolean isWithDraw = false;
								try {
									withDraw = new BigDecimal(0);
									withDraw = new BigDecimal(sc.nextLine());
									isWithDraw = customerService.makeCustomerWithDraw(customerId, withDraw);
									if(isWithDraw) {
										System.out.println("Withdraw made successfully...");
									}
									else {
										throw new BankException("There is a problem in withdraw. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
								
							case 10:
								System.out.print("Enter the amount you would like to transfer: ");
								boolean isTransfer = false;
								try {
									transfer = new BigDecimal(0);
									transfer = new BigDecimal(sc.nextLine());
									transferAccountNumber = null;
									System.out.print("Enter the account number you would like to make a transfer (0000-0000-0000-0000): ");
									transferAccountNumber = sc.nextLine();
									isTransfer = customerService.makeCustomerTransfer(customerId, transfer, transferAccountNumber);
									if(isTransfer) {
										System.out.println("Transaction made successfully...");
									}
									else {
										throw new BankException("There is a problem in tracsaction. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								
								break;
								
							case 11:
								System.out.println("Enter the loan type identification number you would like to apply: ");
								System.out.println("(100) Home ");
								System.out.println("(101) Vehicle ");
								System.out.println("(102) Personal ");
								System.out.println("(103) Education ");
								System.out.println("(104) Business ");
								boolean isLoanApplication = false;
								loanTypeId = 0;
								loanAmount = new BigDecimal(0);
								loanDurationYear = 0;
								
								try{
									loanTypeId = Integer.parseInt(sc.nextLine());
									System.out.print("Enter the loan amount you would like to apply: ");
									loanAmount = new BigDecimal(sc.nextLine());
									System.out.print("Enter the loan duration in year: ");
									loanDurationYear = Integer.parseInt(sc.nextLine());
									
									isLoanApplication = customerService.makeLoanApplication(customerId, loanTypeId, loanAmount, loanDurationYear);
									if(isLoanApplication) {
										System.out.println("Loan application is successful...");
									}
									else {
										throw new BankException("There is a problem in loan application. Please try later....");
									}
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								break;
							
							case 12:
								try {
									boolean isLoanPayment = false;
									BigDecimal loanPayment = new BigDecimal(0);
									System.out.print("Enter the amount you would like to pay: ");
									loanPayment = new BigDecimal(sc.nextLine());
									isLoanPayment = customerService.makeCustomerLoanPayment(customerId, loanPayment);
									if(isLoanPayment) {
										System.out.println("Loan payment made successfully...");
									}
									else {
										throw new BankException("There is a problem in loan payment. Please try later....");
									}
									
								}catch (ClassNotFoundException | SQLException exception) {  //try
									log.error(exception.getMessage());	
								}catch (Exception exception) {
									log.error(exception.getMessage());
								}
								
								break;
							case 13:
								System.out.println("You have existed your customer account!");
								break;
								
							default:
								System.out.println("Your entry is incorrect!");
								System.out.println("Please enter appropriate choice between 1-13\n");
								break;
							
							}  //switch
						}while(customerChoice != 13);   //do-while	
					} // if	
				}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {  //try
					log.error(exception.getMessage());	
				}catch (Exception exception) {
					log.error(exception.getMessage());
				}
				break;
			
			case 2:
				System.out.println("\n\nPlease login.");
				EmployeeService employeeService = new EmployeeServiceImpl();
				try {
					employeeId = employeeService.employeeLogIn();
					
					if (employeeId>0) {
						do {
							System.out.println("\nPLEASE ENTER:");
							System.out.println("(1) If you want to search customer information by customer identification number. ");
							System.out.println("(2) If you want to search customer information by account number. ");
							System.out.println("(3) If you want to search customer information by first name. ");
							System.out.println("(4) If you want to search customer information by last name. ");
							System.out.println("(5) If you want to search customer information by bank branch identification number. ");
							System.out.println("(6) If you want to search all customer information by date of birth range. ");
							System.out.println("(7) If you want to search customer account information by customer identification number. ");
							System.out.println("(8) If you want to search customer account information by account number. ");
							System.out.println("(9) If you want to search all customer account information by bank branch identification number. ");
							System.out.println("(10) If you want to search customer transaction information by customer identification number. ");
							System.out.println("(11) If you want to search customer transaction information by account number. ");
							System.out.println("(12) If you want to search all costumer transaction information by date. ");
							System.out.println("(13) If you want to search all costumer loan application.");
							System.out.println("(14) If you want to exit from your account. \n\n");
							
							employeeChoice = Integer.parseInt(sc.nextLine());
							switch(employeeChoice) {
							
							case 1:
								customerId = 0;
								System.out.print("Enter customer identification number: ");
								try {
									customerId = Integer.parseInt(sc.nextLine());
									customer = employeeService.getCustomerInformationById(customerId);
								} catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 2:
								accountNumber = null;
								System.out.print("Enter customer account number: ");
								try {
									accountNumber = sc.nextLine();
									customer = employeeService.getCustomerInformationByAccountNumber(accountNumber);
								} catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 3:
								customerFirstName = null;
								customerList = null;
								System.out.print("Enter customer first name: ");
								try {
									customerFirstName = sc.nextLine();
									customerList = employeeService.getCustomerInformationByFirstName(customerFirstName);
								}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 4:
								customerLastName = null;
								customerList = null;
								System.out.print("Enter the customer last name: ");
								try {
									customerLastName = sc.nextLine();
									customerList = employeeService.getCustomerInformationByLastName(customerLastName);
								}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 5: 
								bankBranchId = 0;
								customerList = null;
								System.out.print("Enter the bank branch identification number: ");
								try {
									bankBranchId = Integer.parseInt(sc.nextLine());
									customerList = employeeService.getCustomerInformationByBankBranchId(bankBranchId);
								}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 6:
								strSDate = null;
								strEDate = null;
								dateStart = null;
								dateEnd = null;
								customerList = null;
								System.out.print("Enter the start date (mm-dd-yyyy): ");
								strSDate = sc.nextLine();
								System.out.print("Enter the end date (mm-dd-yyyy): ");
								strEDate = sc.nextLine();
								try {
									if(!strSDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}") ||!strEDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}") ) {
										throw new BankException("Invalid Date");
									}else {
										dateStart = new SimpleDateFormat("MM-dd-yyyy").parse(strSDate);
										dateEnd = new SimpleDateFormat("MM-dd-yyyy").parse(strEDate);
										customerList = employeeService.getCustomerByDateOfBirthRange(dateStart, dateEnd);
									}
								}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;	
								
							case 7:
								customerId = 0;
								customerAccount = null;
								System.out.print("Enter customer identification number: ");
								try {
									customerId = Integer.parseInt(sc.nextLine());
									customerAccount =  employeeService.getCustomerAccountById(customerId);
								} catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 8:
								customerAccount = null;
								System.out.print("Enter the customer account number: ");
								try {
									accountNumber = sc.nextLine();
									customerAccount = employeeService.getCustomerAccountByAccountNumber(accountNumber);
								} catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;		
								
							case 9:
								bankBranchId = 0;
								customerAccountList = null;
								System.out.print("Enter the bank branch identification number: ");
								try {
									bankBranchId = Integer.parseInt(sc.nextLine());
									customerAccountList = employeeService.getCustomerAccountByBankBranchId(bankBranchId);
								} catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 10:
								customerId = 0;
								customerTransactionList = null;
								System.out.print("Enter customer identification number: ");
								try {
									customerId = Integer.parseInt(sc.nextLine());
									customerTransactionList =  employeeService.getCustomerTransactionByCustomerId(customerId);
								} catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 11:
								accountNumber = null;
								customerTransactionList = null;
								System.out.print("Enter customer account number: ");
								try {
									accountNumber = sc.nextLine();
									customerTransactionList = employeeService.getCustomerTransactionByAccountNumber(accountNumber);
								}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 12:
								strDate = null;
								date = null;
								System.out.print("Enter the date (mm-dd-yyyy): ");
								strDate = sc.nextLine();
								allCustomerTransactionList = null; 
								try {
									if(!strDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
										throw new BankException("Invalid Date");
									}else {
										date = new SimpleDateFormat("MM-dd-yyyy").parse(strDate);
										allCustomerTransactionList = employeeService.getAllCustomerTransactionByDate(date);
									}
								}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
							
							case 13:
								allCustomerLoanList = null;
								try {
									allCustomerLoanList = employeeService.getAllCustomerLoanApplication();
									
								}catch (NumberFormatException | ClassNotFoundException | SQLException exception) {
									log.error(exception.getMessage());
								}catch (Exception exception) {
									log.error(exception.getMessage());	
								}
								break;
								
							case 14:
								System.out.println("You have existed your employee account!");
								break;
								
							default:
								System.out.println("Your entry is incorrect!");
								System.out.println("Please enter appropriate choice between 1-14\n");
								break;
							}	// switch
						}while(employeeChoice != 14);  //do-while
							
					} //if
					
				}catch (NumberFormatException | BankException | ClassNotFoundException | SQLException exception) {  //try
						log.error(exception.getMessage());		
				}catch (Exception exception) {
					log.error(exception.getMessage());		
				}
				break;
				
			case 3:
				System.out.println("Please enter the following information to open an account");
				boolean applicationConfirmation = false;
				
				NewComerService newComer = new NewComerServiceImpl();
				try {
					applicationConfirmation = newComer.NewComerApplication();
				} catch (BankException | ClassNotFoundException | SQLException exception) {
					log.error(exception.getMessage());
				}
				
				if(applicationConfirmation) {
					System.out.println("Wellcome Again to Asya Bank\n\n\n");
				}
				break;
			
			case 4:
				System.out.println("Thank you for using Asya Bank App");
				break;
			
			default:
				System.out.println("Invalid Input");
				System.out.println("Please enter appropriate choice between 1-4\n");
			}
			
		}while(choice!=4);
	}

}